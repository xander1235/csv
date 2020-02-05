package com.guru.csv.parser;

import com.guru.csv.csvbind.CSVCarModel;
import com.guru.csv.model.CarModel;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CSVParser {

    public List<CSVCarModel> parse(File file) throws FileNotFoundException {
        return new CsvToBeanBuilder<CSVCarModel>(new FileReader(file))
                .withType(CSVCarModel.class).build().parse();
    }

    public List<CarModel> buildEntity(List<CSVCarModel> csvCarModels) {
        return csvCarModels.stream().map(CarModel::new).collect(Collectors.toList());
    }
}
