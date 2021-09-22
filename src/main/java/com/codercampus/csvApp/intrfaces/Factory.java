package com.codercampus.csvApp.intrfaces;

import org.apache.commons.csv.CSVRecord;

public interface Factory<T> {

    /**
     *
     * @param data - a record read from a csv file
     * @return returns an instance of the provided type
     * @throws Exception
     */
    T create(CSVRecord data) throws Exception;

}
