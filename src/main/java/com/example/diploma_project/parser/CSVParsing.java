package com.example.diploma_project.parser;

import com.example.diploma_project.entity.Ontology;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVParsing {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "id", "instance", "class", "data_property_name","data_property_value"
            ,"object_property_name","object_property_name"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Ontology> csvToOntology(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser  csvParser = new CSVParser (fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Ontology> ontologies = new ArrayList<Ontology>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Ontology ontology = new Ontology(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("instance"),
                        csvRecord.get("class"),
                        csvRecord.get("data_property_name"),
                        csvRecord.get("data_property_value"),
                        csvRecord.get("object_property_name"),
                        csvRecord.get("object_property_name")
                );

                ontologies.add(ontology);
            }

            return ontologies;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Ontology> tutorials) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Ontology ontology : tutorials) {
                List<String> data = Arrays.asList(
                        String.valueOf(ontology.getId()),
                        ontology.getInstance(),
                        ontology.getOnto_class(),
                        ontology.getData_property_name(),
                        ontology.getData_property_value(),
                        ontology.getObject_property_name(),
                        ontology.getObject_property_value()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}


