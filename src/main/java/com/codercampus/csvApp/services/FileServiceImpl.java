package com.codercampus.csvApp.services;

import com.codercampus.csvApp.domain.Recipe;
import com.codercampus.csvApp.intrfaces.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class FileServiceImpl implements FileService {

    /**
     * Reads file into an ArrayList
     */
    public Iterable<CSVRecord> readFile() throws IOException {
        // Store file path
        File file = new File("data/recipes.txt");

        Reader input = new FileReader(file);

        return CSVFormat.Builder.create()
                .setHeader()
                .setSkipHeaderRecord(true)
                .setIgnoreSurroundingSpaces(true)
                .setEscape('\\')
                .build().parse(input);

    }


}
