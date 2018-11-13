package com.cg.bam.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountService;
import com.cg.bam.service.BankAccountServiceImpl;

public class TestClass {
	  @Test
	    public void test_validateName_v2() throws BankAccountException{
	    
	        String name="Amita";
	        BankAccountService service=new BankAccountServiceImpl();
	        boolean result= service.validateName(name);
	        Assert.assertEquals(true,result);
	    }
	  
	  @Test
	    public void test_validateName_v1() throws BankAccountException{
	    
	        String name="amita";
	        BankAccountService service=new BankAccountServiceImpl();
	        boolean result= service.validateName(name);
	        Assert.assertEquals(false,result);
	    }
}
