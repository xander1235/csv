package com.guru.csv.controller;

import com.guru.csv.csvbind.CSVCarModel;
import com.guru.csv.model.CarModel;
import com.guru.csv.parser.CSVParser;
import com.guru.csv.repository.CarModelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CsvController {

    private  CSVParser csvParser;


    private CarModelRepository carModelRepository;

    public CsvController(CSVParser csvParser, CarModelRepository carModelRepository) {
        this.csvParser = csvParser;
        this.carModelRepository = carModelRepository;
    }
    public CsvController() {

    }

    @GetMapping(value = "upload")
    public String upload() throws FileNotFoundException {
        String fileName = "final_data_processed.csv";
        ClassLoader classLoader = new CsvController().getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        List<CSVCarModel> csvCarModels = csvParser.parse(file);
        List<CarModel> carModels = csvParser.buildEntity(csvCarModels);
        carModelRepository.save(carModels);
        return "success" + carModels.size();
    }
}
