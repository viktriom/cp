/**
 * 
 */
package com.bds.cp.executors.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

/**
 * @author Vivek Tripathi
 *
 */
@ExecutableCommand(commandDescription = "", commandParams = {"",""}, commandParamsDescription = {"",""})
public class MapExperiment implements Executor {


    public Command commandProcessor(String stringCommand) {
        return null;
    }


    public void execute(Command cmd){
		System.out.println("Executing the commmand MapExperiment..");
		Map<String,List<String>> test = new HashMap<String,List<String>>();
		List<TestData> lst = new ArrayList<TestData>();
		String kerb[] = {"tripvi","mongan","bhanra"};
		String data[] = {"data1","data2","data3","data4","data5","data6","data7","data8"};
		
		Random rn = new Random();
		
		int randomNum;
		
		for(int i =0;i<10;i++){
			randomNum =  rn.nextInt() % 3;
			randomNum = randomNum<0?0-randomNum:randomNum;
			String kerberos = kerb[randomNum];
			//System.out.println("[Random Number, kerb] = [" + randomNum +"," + kerberos + "]");
			randomNum =  rn.nextInt() % 8;
			randomNum = randomNum<0?0-randomNum:randomNum;
			String dataa = data[randomNum];
			//System.out.println("[Random Number, data] = [" + randomNum +"," + dataa + "]");
			TestData tstDat = new TestData(kerberos,dataa);
			System.out.println(tstDat);
			lst.add(tstDat);
		}
		
		for(TestData tstData : lst){
			String kerberos = tstData.getKerb();
			List<String> datLst;
			if((datLst = test.get(kerberos))==null){
				datLst = new ArrayList<String>();
				test.put(kerberos, datLst);
			}
			
			datLst.add(tstData.getData());
		}
		
		System.out.println(test.toString());
		
		System.out.println("Execution of the command MapExperiment Completed.");
	}
	
	class TestData{
		String kerb;
		String data;
		
		public TestData(String kerb, String data){
			this.kerb = kerb;
			this.data = data;
		}
		
		public void setKerb(String kerb){
			this.kerb = kerb;
		}
		
		public void setData(String data){
			this.data = data;
		}
		
		public String getKerb(){
			return this.kerb;
		}
		
		public String getData(){
			return this.data;
		}
		
		public String toString(){
			return "["+kerb+","+data+"]";
		}
	}
}
