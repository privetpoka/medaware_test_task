package com.vasilii.service;

import com.vasilii.model.InputData;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DataService {

    Set<InputData> getInputData(List<String> dataFromFile);

}
