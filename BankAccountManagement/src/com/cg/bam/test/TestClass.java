package com.cg.bam.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.cg.bam.exception.BankAccountException;
import com.cg.bam.service.BankAccountService;
import com.cg.bam.service.BankAccountServiceImpl;

public class TestClass {

	@Test(expected=BankAccountException.class)
    public void test_ValidateName_null() throws BankAccountException{
        BankAccountService service=new BankAccountServiceImpl();
        service.validateName(null);
    }
    
    @Test
    public void test_validateName_v1() throws BankAccountException{
    
        String name="Aete121";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateName_v2() throws BankAccountException{
    
        String name="Amita";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateName_v3() throws BankAccountException{
    
        String name="amita";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test(expected=BankAccountException.class)
    public void test_ValidateMobNo_null() throws BankAccountException{
        BankAccountService service=new BankAccountServiceImpl();
        service.validateMoileNo(null);
    }
    
    @Test
    public void test_validateMobNo_v1() throws BankAccountException{
    
        String mobNo="ABCD91828288";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateMobNo_v2() throws BankAccountException{
    
        String mobNo="9922974725";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateMobNo_v3() throws BankAccountException{
    
        String mobNo="992297";
        BankAccountService service=new BankAccountServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
	
}
