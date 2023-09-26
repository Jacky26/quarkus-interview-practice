package org.jc.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.jc.model.Customer;
import org.jc.util.Enums;

import java.util.ArrayList;
import java.util.List;

import static org.jc.util.Constant.MAX_MATCH_COUNT;

@ApplicationScoped
public class DataProcessingService {

    private boolean isDuplicate(Customer customer1, Customer customer2){
        int matchCount = 0;

        for(Enums.CustomerMatchingCriteria customerMatchingCriteria : Enums.CustomerMatchingCriteria.values()){
            if(customerMatchingCriteria.isMatching(customer1, customer2)){
                matchCount++;
            }
        }

        return matchCount >= MAX_MATCH_COUNT;
    }

    public List<Customer> convertDataToList(String data){
        List<Customer> customers = new ArrayList<>();
        String[] records = data.split("\n");

        for(String record : records){
            String[] customerData = record.split(",");
            Customer customer = new Customer();
            customer.setId(customerData[0]);
            customer.setName(customerData[1]);
            customer.setIdType(customerData[2]);
            customer.setIdNo(customerData[3]);
            customer.setDob(customerData[4]);
            customers.add(customer);
        }

        return customers;
    }

    public String findDuplicateCustomer(List<Customer> customers){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < customers.size(); i++){
            for(int j=i+1; j < customers.size(); j++){
                if(isDuplicate(customers.get(i), customers.get(j))){
                    sb.append("Record ").append(customers.get(i).getId()).append(" and ")
                            .append(customers.get(j).getId()).append(" are the same person.").append("\n");
                }
            }
        }
        sb.append("All records validated.");
        return sb.toString();
    }
}
