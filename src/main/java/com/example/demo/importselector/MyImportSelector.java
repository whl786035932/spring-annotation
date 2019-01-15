package com.example.demo.importselector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		
		return new String[] {"com.example.demo.importt.Blue","com.example.demo.importt.Yellow"};
	}

}
