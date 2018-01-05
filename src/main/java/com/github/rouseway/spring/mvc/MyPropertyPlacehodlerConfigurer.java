package com.github.rouseway.spring.mvc;

import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


//this class should be defined as bean in "*-servlet.xml"
public class MyPropertyPlacehodlerConfigurer extends 
		PropertyPlaceholderConfigurer {

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		try {
			if (logger.isDebugEnabled()) {
				logger.debug("system property '" + props + "': ");
			}
		} catch (Exception e) {
			logger.error("initialization failed", e);
		}
		super.processProperties(beanFactoryToProcess, props);
		
		//set all of the parameters at here
		MyConfigure.greet = props.getProperty(MyConfigure.PARAM_GREET);
		MyConfigure.object =props.getProperty(MyConfigure.PARAM_OBJECT);
	}
		
}
