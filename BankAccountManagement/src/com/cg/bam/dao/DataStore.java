package com.cg.bam.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.bam.dto.Customer;

public class DataStore {
	private static Map<String, Customer> customer;
	static Map<String, Customer> createCollection(){
		if(customer == null)
			customer = new HashMap<>();		
		return customer;		
	}

}
