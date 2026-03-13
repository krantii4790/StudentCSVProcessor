package com.csv.util;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class CsvHelper {

    public static File processCSV(InputStream is) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        // Check StudentName column
        if (!parser.getHeaderMap().containsKey("StudentName")) {
            throw new RuntimeException("CSV must contain StudentName column");
        }

        List<String> headers = new ArrayList<>(parser.getHeaderMap().keySet());
        headers.remove("StudentName");

        int subjectCount = headers.size();

        List<List<String>> rows = new ArrayList<>();

        for (CSVRecord record : parser) {

            String name = record.get("StudentName");

            int total = 0;

            List<String> row = new ArrayList<>();
            row.add(name);

            for (String subject : headers) {

                int mark = Integer.parseInt(record.get(subject));

                total += mark;

                row.add(String.valueOf(mark));
            }

            double percentage = total / (double) subjectCount;

            row.add(String.valueOf(total));
            row.add(String.format("%.2f", percentage));

            rows.add(row);
        }

        // ⭐ Sort by Percentage (Highest → Lowest)
        rows.sort((r1, r2) -> {
            double p1 = Double.parseDouble(r1.get(r1.size() - 1));
            double p2 = Double.parseDouble(r2.get(r2.size() - 1));
            return Double.compare(p2, p1);
        });

        // Create headers
        List<String> newHeaders = new ArrayList<>();
        newHeaders.add("StudentName");
        newHeaders.addAll(headers);
        newHeaders.add("Total");
        newHeaders.add("Percentage");

        File output = new File("result.csv");

        CSVPrinter printer = new CSVPrinter(
                new FileWriter(output),
                CSVFormat.DEFAULT.withHeader(newHeaders.toArray(new String[0]))
        );

        for (List<String> row : rows) {
            printer.printRecord(row);
        }

        printer.close();

        return output;
    }
}