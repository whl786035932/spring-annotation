package com.example.demo.config;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyFilterType implements TypeFilter{

	public boolean match(MetadataReader arg0, MetadataReaderFactory arg1) throws IOException {
		
		return false;
	}

}
