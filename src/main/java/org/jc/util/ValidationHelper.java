package org.jc.util;


import org.jc.exception.CustomException;

import static org.jc.util.Enums.ErrorCode.DATA_REQ_ERROR_CD;

public class ValidationHelper {

    public static void isNull(Object obj) throws CustomException {
        if(obj == null){
            throw new CustomException(DATA_REQ_ERROR_CD.getMessage(), DATA_REQ_ERROR_CD);
        }
    }
    public static void isEmptyOrNull(String str) throws CustomException {
        if(str.isEmpty()){
            throw new CustomException(DATA_REQ_ERROR_CD.getMessage(), DATA_REQ_ERROR_CD);
        }
    }
}
