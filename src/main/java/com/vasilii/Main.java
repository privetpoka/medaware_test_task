package com.vasilii;

import com.vasilii.model.InputData;
import com.vasilii.service.AnalyticService;
import com.vasilii.service.DataService;
import com.vasilii.service.FileService;
import com.vasilii.service.impl.AnalyticServiceImpl;
import com.vasilii.service.impl.DataServiceImpl;
import com.vasilii.service.impl.FileServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Started test service");
        AnalyticService analyticService = new AnalyticServiceImpl();
        DataService dataService = new DataServiceImpl();
        FileService fileService = new FileServiceImpl();

        List<String> dataFromFile = fileService.getDataFromFile();
        Set<InputData> inputData = dataService.getInputData(dataFromFile);
        String result = analyticService.groupAndAnalyzeData(inputData);
        try {
            fileService.writeResultToFile(result);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to analyze data", e);
        }

//        try {
//            Thread.sleep(10 * 60 * 1000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
}
