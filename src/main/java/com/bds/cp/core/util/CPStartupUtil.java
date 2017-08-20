package com.bds.cp.core.util;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.executors.Executable;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

public class CPStartupUtil {

	private static Logger log = Logger.getLogger(CPStartupUtil.class);

	public static void initializeCommandProcessingSystem() {
		loadCommands();
		CPUtil.loadPropertiesFileIntoClass(CPUtil.getPathForString("cp.properties"), "CPConstants", true);
		CPConstants.setIsInitializationComplete(true);
	}

	public static void loadCommands() {
		log.info("Loading executable commands...");
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(ExecutableCommand.class));
		Class<?> executor;
		String applicationContext = CPConstants.getCommandContext().substring(0, CPUtil.getIndexOfCharFromRight(CPConstants.getCommandContext(), '.'));
		for (BeanDefinition bd : scanner.findCandidateComponents(applicationContext)) {
			try {
				executor = Class.forName(bd.getBeanClassName());
				Executable command = (Executable) executor.newInstance();
				CPStore.addCommandToStore(command);
			} catch (ClassNotFoundException ex) {
				log.error("Command not found : " + bd.getBeanClassName());
			} catch (InstantiationException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error("Command not found : " + bd.getBeanClassName());
				log.error(e.getMessage());
				e.getStackTrace();
			}

			log.info("Loaded Command : " + bd.getBeanClassName());

		}
		log.info("Done with command loading.");
	}

	public static void reloadCommandBase() {
		CPStore.clearCommandStore();
		loadCommands();
	}

}
