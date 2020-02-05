package com.guru.csv.controller;

import com.guru.csv.csvbind.CSVCarModel;
import com.guru.csv.model.CarModel;
import com.guru.csv.parser.CSVParser;
import com.guru.csv.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

@RestController
public class CsvController {

    private final CSVParser csvParser;

    private final CarModelRepository carModelRepository;

    public CsvController(CSVParser csvParser, CarModelRepository carModelRepository) {
        this.csvParser = csvParser;
        this.carModelRepository = carModelRepository;
    }

    @GetMapping(value = "upload")
    public String upload() throws FileNotFoundException {
        String fileName = "final_data_processed.csv";
        ClassLoader classLoader = CsvController.class.getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        List<CSVCarModel> csvCarModels = csvParser.parse(file);
        List<CarModel> carModels = csvParser.buildEntity(csvCarModels);
        carModels.parallelStream().forEach(carModelRepository::save);
        return "success" + carModels.size();
    }
}
