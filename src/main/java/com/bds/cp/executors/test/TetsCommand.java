/**
 * 
 */
package com.bds.cp.executors.test;

import java.sql.Timestamp;

import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

/**
 * @author tripvi
 *
 */
@ExecutableCommand(commandDescription = "", commandParams = {"",""}, commandParamsDescription = {"",""})
public class TetsCommand implements Executor {

	/* (non-Javadoc)
	 * @see com.test.executors.Executor#execute(com.test.bean.Command)
	 */
	public void execute(Command command) {
		
		//test0(command);
		//test1();
		//test2(command);
		test3();
		
	}
	
	private void test3(){
		/*Date date = new Date();*/
		long time = System.currentTimeMillis();
		System.out.println(time+"\t"+new Timestamp(time));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long time1 = System.currentTimeMillis();
		long diff = time1 -time;
		System.out.println(time1);
		System.out.println(diff);
	}
	
	private void test1(){
		String colonSeparatedPath  = "xml:domain:mithra:MithraRuntimeConfig.xml:";
		System.out.println(colonSeparatedPath);
		String temp = CPUtil.getPathForString(colonSeparatedPath);
		String pathElems[] = colonSeparatedPath.split(":");
		String path="";
		int i=0;
		for(i=0;i<=(pathElems.length-2);i++){
			path = path + pathElems[i] + CPConstants.getFilePathSeperator();
		}
		path = path + pathElems[i];
		System.out.println(temp);
	}
	
	public void test0(Command command){
		System.out.println("The command entered is : " + command);
		String str = "this.is.a.test";
		String[] test = str.split("\\.");
		System.out.println("number of elements in \"this.is.a.test\" is : " + test.length);
		for(String tst : test){
			System.out.println(tst);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.test.executors.Executor#commandProcessor(java.lang.String)
	 */
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}