package com.vasilii;

import com.vasilii.model.InputData;
import com.vasilii.service.AnalyticService;
import com.vasilii.service.DataService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Started test service");
        AnalyticService analyticService = new AnalyticService();
        DataService dataService = new DataService();

        List<InputData> inputData = dataService.getInputData();
        try {
            analyticService.groupAndAnalyzeData(inputData);
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
