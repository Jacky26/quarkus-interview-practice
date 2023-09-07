package org.jc.util;


import org.jc.model.Customer;

public class Enums {

    //We can add more criteria here instead of the comparison method in the future
    public enum CustomerMatchingCriteria {

        NAME{
            @Override
            public boolean isMatching(Customer customer1, Customer customer2){
                return customer1.getName().equals(customer2.getName());
            }
        },
        ID_TYPE_ID_NO{
            @Override
            public boolean isMatching(Customer customer1, Customer customer2){
                return customer1.getIdType().equals(customer2.getIdType()) && customer1.getIdNo().equals(customer2.getIdNo());
            }
        },
        DOB {
            @Override
            public boolean isMatching(Customer customer1, Customer customer2) {
                return customer1.getDob().equals(customer2.getDob());
            }
        };

        public abstract boolean isMatching(Customer customer1, Customer customer2);
    }

    public enum ErrorCode {
        READ_FILE_ERROR_CD("ERR_1001", "Error occurred while reading file."),
        DATA_REQ_ERROR_CD("ERR_1002", "Data passed is null or empty");

        ErrorCode(String code, String message) {
            this.code = code;
            this.message = message;
        }

        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
