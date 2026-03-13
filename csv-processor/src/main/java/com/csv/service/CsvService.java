package com.csv.service;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csv.util.CsvHelper;

@Service
public class CsvService {

    public Resource processFile(MultipartFile file) throws Exception {

        File processed = CsvHelper.processCSV(file.getInputStream());

        return new FileSystemResource(processed);
    }
}
