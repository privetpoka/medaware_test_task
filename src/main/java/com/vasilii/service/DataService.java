package com.vasilii.service;

import lombok.NoArgsConstructor;
import com.vasilii.model.InputData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DataService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");


    Logger logger = Logger.getLogger(DataService.class.getName());

    public List<InputData> getInputData() {
        return getDataFromFile().stream().map(this::parseStringToInputData).collect(Collectors.toList());

    }

    private List<String> getDataFromFile() {
        logger.log(Level.INFO, "fetching data from file");
        Class<?> clazz = DataService.class;
        InputStream inputStream = clazz.getResourceAsStream("/task1_output.txt");
        return readFromInputStream(inputStream);
    }

    private List<String> readFromInputStream(InputStream inputStream) {
        List<String> res = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.add(line);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Fail to open file", e);
        }
        return res;
    }


    private InputData parseStringToInputData(String input) {
        String[] s = input.split(" ", 4);
        LocalDate localDate = LocalDate.parse(s[0], DATE_FORMATTER);
        LocalTime time = LocalTime.parse(s[1], TIME_FORMATTER);
        String name = s[2];
        String action = s[3];
        return new InputData(localDate, time, name, action, input);
    }

}
