package com.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.service.CsvService;

@RestController
@RequestMapping("/api/csv")
@CrossOrigin("*")
public class CsvController {

    @Autowired
    private CsvService csvService;

    @PostMapping("/upload")
    public ResponseEntity<Resource> uploadCSV(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new RuntimeException("Uploaded file is empty");
        }

        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new RuntimeException("Only CSV files are allowed");
        }

        Resource resource = csvService.processFile(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=result.csv")
                .body(resource);
    }
}
