package com.cocast.cocast.service;

import com.cocast.cocast.model.CocaRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CocaService {

    private final List<CocaRecord> records = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        try {
            ClassPathResource resource = new ClassPathResource("cultivos_coca.csv");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                
                String line = reader.readLine();
                while ((line = reader.readLine()) != null) {
                    if (line.isBlank()) continue;
                    String[] cols = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if (cols.length >= 28) {
                        records.add(new CocaRecord(clean(cols[1]), clean(cols[3]), clean(cols[26]), clean(cols[27])));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo el CSV: " + e.getMessage());
        }
    }

    private String clean(String value) {
        if (value == null || value.isBlank()) return "0";
        return value.replace("\"", "").trim();
    }

    public List<CocaRecord> search(String municipality) {
        if (municipality == null || municipality.isBlank()) {
            return records;
        }
        String query = municipality.trim().toLowerCase();
        return records.stream()
                .filter(r -> r.municipio().toLowerCase().contains(query))
                .toList();
    }
}
