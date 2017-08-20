/**
 * 
 */
package com.bds.cp.bean;

import com.bds.cp.executors.Executable;

/**
 * @author tripvi (Tripathi, Vivek)
 *
 */
public class CommandBean {
	private Executable executor;
	private long lastAccessTime;
	
	public CommandBean(){
		executor = null;
		lastAccessTime=0;
	}
	
	public CommandBean(Executable executor, long lastAccessTime){
		this.executor = executor;
		this.lastAccessTime = lastAccessTime;
	}

	public Executable getExecutor() {
		return executor;
	}
	
	public void setExecutor(Executable executor) {
		this.executor = executor;
	}
	
	public long getLastAccessTime() {
		return lastAccessTime;
	}
	
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
}
