package com.hrms.karcan.core.utilities.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;


public class ModelMapperUtils {
	private static ModelMapper modelMapper = new ModelMapper();

	public static <S, T> List<T> toList(List<S> source, Class<T> targetClass){
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		
		return source.stream().map(element -> modelMapper.map(element, targetClass))
				.collect(Collectors.toList());
		
	}
	
	public static <T> Object toObject(Object source, Class<T> baseClass) {
		return modelMapper.map(source,baseClass);
		
	}
}
