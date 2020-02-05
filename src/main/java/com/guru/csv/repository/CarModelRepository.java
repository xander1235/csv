package com.guru.csv.repository;

import com.guru.csv.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

}
