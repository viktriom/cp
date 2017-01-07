/**
 * 
 */
package com.bds.cp.bean;

import com.bds.cp.executors.Executor;

/**
 * @author tripvi (Tripathi, Vivek)
 *
 */
public class CommandBean {
	private Executor executor;
	private long lastAccessTime;
	
	public CommandBean(){
		executor = null;
		lastAccessTime=0;
	}
	
	public CommandBean(Executor executor, long lastAccessTime){
		this.executor = executor;
		this.lastAccessTime = lastAccessTime;
	}
	
	public Executor getExecutor() {
		return executor;
	}
	
	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	public long getLastAccessTime() {
		return lastAccessTime;
	}
	
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
}
