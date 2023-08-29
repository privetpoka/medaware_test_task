package com.vasilii.service.impl;

import com.vasilii.service.FileService;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class FileServiceImpl implements FileService {


    private static final String resultPath = System.getProperty("result_path");



    Logger logger = Logger.getLogger(FileServiceImpl.class.getName());


    @Override
    public List<String> getDataFromFile() {
        logger.log(Level.INFO, "fetching data from file");
        Class<?> clazz = FileServiceImpl.class;
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

    @Override
    public void writeResultToFile(String result) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(resultPath));
        writer.write(result);

        writer.close();
    }
}
