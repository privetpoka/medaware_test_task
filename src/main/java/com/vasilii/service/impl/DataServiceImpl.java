package com.vasilii.service.impl;

import com.vasilii.model.InputData;
import com.vasilii.service.DataService;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DataServiceImpl implements DataService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Override
    public Set<InputData> getInputData(List<String> dataFromFile) {
        return dataFromFile.stream().map(this::parseStringToInputData).collect(Collectors.toSet());

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
