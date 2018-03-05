package com.example.demo.filtering.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.filtering.models.DynamicFilteringBean;
import com.example.demo.filtering.models.FilteringBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public FilteringBean filterBean() {
		
		return new FilteringBean("test1", "test2", "test3");
	}
	
	@GetMapping("/list-filtering")
	public List<FilteringBean> filterBeanList() {
		
		List<FilteringBean> list = new ArrayList<FilteringBean>();
		list.add(new FilteringBean("test1", "test2", "test3"));
		list.add(new FilteringBean("test1", "test2", "test3"));
		list.add(new FilteringBean("test1", "test2", "test3"));
		list.add(new FilteringBean("test1", "test2", "test3"));
		
		return list;
	}
	
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue dynamicFilterBean() {
		
		DynamicFilteringBean dynamicFilteringBean = new DynamicFilteringBean("test1", "test2", "test3");
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicFilteringBean);
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBean", propertyFilter);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/dynamic-list-filtering")
	public MappingJacksonValue dynamicFilterBeanList() {
		
		List<DynamicFilteringBean> list = new ArrayList<DynamicFilteringBean>();
		list.add(new DynamicFilteringBean("test1", "test2", "test3"));
		list.add(new DynamicFilteringBean("test1", "test2", "test3"));
		list.add(new DynamicFilteringBean("test1", "test2", "test3"));
		list.add(new DynamicFilteringBean("test1", "test2", "test3"));
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBean", propertyFilter);
		mapping.setFilters(filters);
		
		return mapping;
	}
}
