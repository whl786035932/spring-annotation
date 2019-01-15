package com.example.demo.importselector;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean containsBlue = registry.containsBeanDefinition("com.example.demo.importt.Blue");
		boolean containsYellow = registry.containsBeanDefinition("com.example.demo.importt.Yellow");
		if(containsBlue&&containsYellow) {
			RootBeanDefinition rootBeanDefinition = new RootBeanDefinition("com.example.demo.importt.Rabbow");
			registry.registerBeanDefinition("rabbow",rootBeanDefinition );
		}
		
	}

}
