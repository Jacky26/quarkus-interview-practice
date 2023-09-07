package org.jc.service;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.jc.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.jc.util.Enums.ErrorCode.READ_FILE_ERROR_CD;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class FileReaderServiceTest {

    @Inject
    FileReaderService fileReaderService;

    @Test
    void readFromCsv_WhenFileNotExist_ShouldThrowCustomError(){
        String fileName= "anything.txt";
        CustomException customException = assertThrows(CustomException.class, () -> fileReaderService.readFromCsv(fileName));
        assertEquals(READ_FILE_ERROR_CD.getCode(), customException.getErrorCode().getCode());
    }

    @Test
    void readFromCsv_WhenFileExist_ShouldReturnAppendedString() throws CustomException {
        String fileName= "interviewFindRelationship.csv";
        String result =  fileReaderService.readFromCsv(fileName);
        assertNotNull(result);
        assertTrue(result.contains("001,James Bond,IC,007,1920/02/28"));
    }
}