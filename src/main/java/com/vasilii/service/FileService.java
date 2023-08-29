package com.vasilii.service;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<String> getDataFromFile();

    void writeResultToFile(String result) throws IOException;
}
