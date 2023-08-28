package com.vasilii.service;

import com.vasilii.model.InputData;

import java.io.IOException;
import java.util.Set;

public interface AnalyticService {
    void groupAndAnalyzeData(Set<InputData> inputDataList) throws IOException;
}
