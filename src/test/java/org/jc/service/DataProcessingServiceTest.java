package org.jc.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.jc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DataProcessingServiceTest {

    @Inject
    DataProcessingService dataProcessingService;
    private final List<Customer> customerList = new ArrayList<>();

    @BeforeEach
    void setUp(){
        customerList.add(buildCustomerModel("001","James Bond","PP" ,"123", "1999/03/09"));
        customerList.add(buildCustomerModel("002","Reece James","IC" ,"123", "1999/03/27"));
        customerList.add(buildCustomerModel("003","Reborn James","IC" ,"123", "1999/03/27"));
        customerList.add(buildCustomerModel("004","James Bond","IC" ,"999", "1999/03/09"));
        customerList.add(buildCustomerModel("005","Reece James","IC" ,"123", "1999/04/19"));
    }


    @Test
    void convertDataToList_WhenHasData_ShouldReturnCustomerList(){
        String data = "001,James Bond,IC,007,1920/02/28\n" +
                      "002,Ian Flaming,IC,007,1920/02/28\n" +
                      "003,James Bond,IC,777,1990/12/30";
        List<Customer> customers = dataProcessingService.convertDataToList(data);
        assertNotNull(customers);
        customers.forEach(customer -> System.out.println(customer.getName()));
    }

    @Test
    void findDuplicateCustomer_WhenCustomersDuplicated_ShouldPrintValue(){
        String result = dataProcessingService.findDuplicateCustomer(customerList);
        assertTrue(result.contains("Record 001 and 004 are the same person."));
        assertTrue(result.contains("All records validated."));
        System.out.println(result);
    }

    private Customer buildCustomerModel(String id, String name, String idType, String idNo, String dob){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setIdType(idType);
        customer.setIdNo(idNo);
        customer.setDob(dob);
        return customer;
    }
}