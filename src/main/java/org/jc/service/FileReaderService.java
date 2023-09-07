package org.jc.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.jc.exception.CustomException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.jc.util.Enums.ErrorCode.READ_FILE_ERROR_CD;

@ApplicationScoped
public class FileReaderService {

    public String readFromCsv(String csvFileName) throws CustomException {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader reader = new FileReader(csvFileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.lines().forEach(line -> sb.append(line).append("\n"));

        } catch (IOException e) {
            throw new CustomException(e.getMessage(), READ_FILE_ERROR_CD);
        }

        return sb.toString();
    }

}
