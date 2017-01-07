package com.bds.cp.core.util;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.executors.Executor;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class CPStartupUtil {

	private static Logger log = Logger.getLogger(CPStartupUtil.class);
	
	public static void loadCommands(){
		log.info("Loading executable commands...");
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
		Executor executor;
		String fullCommandName;

		scanner.addIncludeFilter(new AnnotationTypeFilter(ExecutableCommand.class));
		String applicationContext = CPConstants.getApplicationContext();
		applicationContext = applicationContext.substring(0, CPUtil.getIndexOfCharFromRight(applicationContext, '.'));
		for (BeanDefinition bd : scanner.findCandidateComponents(applicationContext)){
			fullCommandName = bd.getBeanClassName();
			try{
				Class<Executor> c = (Class<Executor>) Class.forName(fullCommandName);
				executor = c.newInstance();
				CPStore.putCommandInCommandStore(fullCommandName, executor);
			} catch(ClassNotFoundException ex){
				log.error("Command not found : " + fullCommandName);
			} catch (InstantiationException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error("Command not found : " + fullCommandName);
				log.error(e.getMessage());
				e.getStackTrace();
			}
			
			log.info("Loaded Command : "+fullCommandName);
		    
		}
		log.info("Done with command loading.");
	}
	
	public static void reloadCommandBase(){
		CPStore.clearCommandStore();
		loadCommands();
	}
	
}
