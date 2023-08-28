package com.vasilii.service;

import com.vasilii.model.InputData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticService {

    private static final Logger logger = Logger.getLogger(AnalyticService.class.getName());

    private Map<String, Set<InputData>> groupData(List<InputData> inputData) {

        logger.log(Level.INFO, "grouping data");

        Map<String, Set<InputData>> groupedData = new HashMap<>();

        inputData.forEach(data ->
                groupedData.compute(data.getAction(), (s, dataset) -> {
                    if (dataset == null) {
                        dataset = new HashSet<>();
                    }
                    dataset.add(data);
                    return dataset;
                }));
        return groupedData;
    }

    private String analyzeData(Map<String, Set<InputData>> groupedData) {
        logger.log(Level.INFO, "analyzing data");

        StringBuilder stringBuilder = new StringBuilder();
        groupedData.forEach((action, data) -> {
            StringBuilder changing = new StringBuilder("The changing word was: ");
            data.forEach(item -> {
                stringBuilder.append(item.getOriginalString()).append("\n");
                changing.append(item.getName()).append(", ");
            });
            changing.delete(changing.length() - 2, changing.length());
            stringBuilder.append(changing).append("\n");
        });

        return stringBuilder.toString();
    }

    public void groupAndAnalyzeData(List<InputData> inputDataList) throws IOException {
        String result = analyzeData(groupData(inputDataList));
        BufferedWriter writer = new BufferedWriter(new FileWriter("/data/output/result.txt"));
        writer.write(result);

        writer.close();

    }

}
