package com.calculator.app;

import com.calculator.app.dao.CountryDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import java.io.*;

public class FileReaderTest {

    private CountryDAO countryDAO = new CountryDAO();
    private File dataFile = countryDAO.dataFile;

    @Test
    public void testFileExist() {
        boolean fileExists = dataFile.exists();
        boolean fileExistExpected = true;
        assertTrue("File exist!", fileExists==fileExistExpected);
    }

    @Test
    public void testFileIsReadable() {
        boolean fileReadableExpected = true;
        boolean fileReadable = false;
        if (dataFile.canRead()) {
            fileReadable = true;
        }
        assertTrue("File is null", fileReadableExpected == fileReadable);
    }

    @Test
    public void testFileIsNotEmpty() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        boolean isNotEmpty = false;
        boolean isNotEmptyExpected = true;
        if (br.readLine() != null) {
            isNotEmpty = true;
        }
        assertTrue("File is empty", isNotEmptyExpected == isNotEmpty);
        }

}
