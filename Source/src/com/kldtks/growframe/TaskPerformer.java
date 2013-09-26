package com.kldtks.growframe;


import java.util.LinkedList;



/**
 * 任务执行者
 * @author YanLu
 *
 */
public class TaskPerformer {

	private LinkedList<TaskBase> taskRuningList = new LinkedList<TaskBase>();
	private LinkedList<TaskBase> taskStandByList = new LinkedList<TaskBase>();
	
	static TaskPerformer taskPerformer = new TaskPerformer();
	
	private TaskPerformer(){};
	
	public static TaskPerformer getTaskPerformer(){
		
		return taskPerformer;
	}
	
	/**
	 * 执行任务
	 * @param task 需要执行的任务
	 */
	public void performerTask(TaskBase task){
		taskRuningList.add(task);
		task.start();
	}
	
	/**
	 * 添加等待任务
	 * @param task
	 */
	public void addStandByTask(TaskBase task){
		taskStandByList.add(task);
	}
	
	/**
	 * 获取指定task
	 * @param taskId
	 * @param tasktypeNetworkresult 
	 * @return
	 */
	public TaskBase getStandByTask(String taskId, String tasktype){
		
		for( int i = taskStandByList.size()-1;i>=0;i--){
			if(taskStandByList.get(i).getTaskId().equals(taskId) && taskStandByList.get(i).getTaskType().equals(tasktype))
				return taskStandByList.get(i);
		}
		return null;
	}

	/**
	 * 运行等待队列中的任务
	 * @param
	 */
	public void performerStandTask(TaskBase task) {
		taskRuningList.add(task);
		taskStandByList.remove(task);
		task.start();
		
	}
	
	
}
