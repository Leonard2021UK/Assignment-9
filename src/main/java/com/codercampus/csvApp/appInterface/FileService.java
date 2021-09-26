package com.codercampus.csvApp.appInterface;

import org.apache.commons.csv.CSVRecord;

import java.io.IOException;


public interface FileService {

    /**
     * Reads the data from a file
     * @return an iterable Apache Commons CSV Record
     * @throws IOException
     */
    Iterable<CSVRecord> readFile() throws IOException;

}
