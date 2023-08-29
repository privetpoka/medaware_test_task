package com.vasilii.service.impl;

import com.vasilii.model.InputData;
import com.vasilii.service.AnalyticService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticServiceImpl implements AnalyticService {

    private static final Logger logger = Logger.getLogger(AnalyticServiceImpl.class.getName());


    private Map<String, Set<InputData>> groupData(Set<InputData> inputData) {

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

    @Override
    public String groupAndAnalyzeData(Set<InputData> inputDataList) {
        return analyzeData(groupData(inputDataList));


    }

}
