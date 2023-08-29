package com.vasilii.service;

import com.vasilii.model.InputData;

import java.io.IOException;
import java.util.Set;

public interface AnalyticService {
    String groupAndAnalyzeData(Set<InputData> inputDataList);
}
