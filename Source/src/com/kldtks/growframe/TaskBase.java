package com.kldtks.growframe;


import android.os.Process;

/**
 * 
 * <p>TaskBase
 * <p>Extends TaskBase
 * @author KLDTKS
 *
 */
public abstract class TaskBase extends Thread{ 


	public static final String TASKTYPE_NORMAL = "NORMAL";
	
	String taskId = "";
	
	
	@Override
	public void run() {
		super.run();
		Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
		taskInit();
		taskMain();
		
	}

	/**
	 * 任务主要方法
	 */
	public abstract void taskMain();

	/**
	 * 初始化task相关数据
	 */
	public abstract void taskInit();

	
	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	/**
	 * 获取此任务类型
	 * @return 任务类型
	 */
	public String getTaskType(){
		return TASKTYPE_NORMAL;
	}
	
	
}
