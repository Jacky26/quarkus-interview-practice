package org.jc.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jc.exception.CustomException;

public class ObjectMappingHelper {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String toJsonString(Object object) throws Exception {
        ValidationHelper.isNull(object);
        return objectMapper.writeValueAsString(object);
    }
}
