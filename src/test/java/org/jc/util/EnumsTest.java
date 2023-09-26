package org.jc.util;

import static org.junit.jupiter.api.Assertions.*;


import io.quarkus.test.junit.QuarkusTest;
import org.jc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class EnumsTest {
    private final List<Customer> customerList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        customerList.add(buildCustomerModel("001", "James Bond", "PP", "123", "1999/03/09"));
        customerList.add(buildCustomerModel("002", "Reece James", "IC", "123", "1999/03/27"));
        customerList.add(buildCustomerModel("003", "Reborn James", "IC", "123", "1999/03/27"));
        customerList.add(buildCustomerModel("004", "James Bond", "IC", "999", "1999/03/09"));
        customerList.add(buildCustomerModel("005", "Reece James", "IC", "123", "1999/04/19"));
    }

    @Test
    public void matchingCriteria_WhenNameMatch_ShouldReturnTrue() {
        assertTrue(Enums.CustomerMatchingCriteria.NAME.isMatching(customerList.get(0), customerList.get(3)));
    }

    @Test
    public void matchingCriteria_WhenNameNotMatch_ShouldReturnFalse() {
        assertFalse(Enums.CustomerMatchingCriteria.NAME.isMatching(customerList.get(0), customerList.get(1)));
    }

    @Test
    public void matchingCriteria_WhenIdAndIdNoMatch_ShouldReturnTrue() {
        assertTrue(Enums.CustomerMatchingCriteria.ID_TYPE_ID_NO.isMatching(customerList.get(1), customerList.get(2)));
    }

    @Test
    public void matchingCriteria_WhenIdAndIdNoNotMatch_ShouldReturnFalse() {
        assertFalse(Enums.CustomerMatchingCriteria.ID_TYPE_ID_NO.isMatching(customerList.get(0), customerList.get(1)));
    }

    @Test
    public void matchingCriteria_WhenDobMatch_ShouldReturnTrue() {
        assertTrue(Enums.CustomerMatchingCriteria.DOB.isMatching(customerList.get(0), customerList.get(3)));
    }

    @Test
    public void matchingCriteria_WhenDobNotMatch_ShouldReturnFalse() {
        assertFalse(Enums.CustomerMatchingCriteria.DOB.isMatching(customerList.get(1), customerList.get(3)));
    }


/* This is just one example to combine test case instead of doing individually
// Pro: Reduce number of test case
// Cons: Hard to read, might require higher memory usage, change implementation will affect all param to test
@ParameterizedTest
@CsvSource({
        "NAME, 0, 3, true",
        "NAME, 0, 1, false",
        "ID_TYPE_ID_NO, 1, 2, true",
        "ID_TYPE_ID_NO, 0, 1, false",
        "DOB, 0, 3, true",
        "DOB, 1, 3, false"
})
public void matchingCriteria_ShouldReturnExpectedResult(String criteria, int index1, int index2, boolean expectedResult) {
    boolean actualResult = Enums.CustomerMatchingCriteria.valueOf(criteria).isMatching(customerList.get(index1), customerList.get(index2));
    assertEquals(expectedResult, actualResult);
} */


    private Customer buildCustomerModel(String id, String name, String idType, String idNo, String dob) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setIdType(idType);
        customer.setIdNo(idNo);
        customer.setDob(dob);
        return customer;
    }

}