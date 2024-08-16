package com.in28minutes.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
//	@GetMapping("/filtering")
//	public SomeBean filtering() {
//		return new SomeBean("value1","value2","value3");
//	}
	
	FilterProvider filters;
	MappingJacksonValue mappingJacksonValue;
	SimpleBeanPropertyFilter filter;
	
	@GetMapping("/filtering") //field2
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1","value2", "value3");

		mappingJacksonValue = new MappingJacksonValue(someBean);
		
		filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		
		filters = extracted(filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}

	private SimpleFilterProvider extracted(SimpleBeanPropertyFilter filter) {
		return new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
	}
	
//	@GetMapping("/filtering-list")
//	public List<SomeBean> filteringList() {
//		return Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value4","value5","value6"));
//	}
	
	@GetMapping("/filtering-list") //field1
	public MappingJacksonValue filteringList() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2", "value3"),
				new SomeBean("value4","value5", "value6"));
		
		mappingJacksonValue = new MappingJacksonValue(list);
		
		filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		
		filters = extracted(filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	
}