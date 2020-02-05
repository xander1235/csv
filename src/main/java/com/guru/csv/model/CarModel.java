package com.guru.csv.model;

import com.guru.csv.csvbind.CSVCarModel;

import javax.persistence.*;

@Entity
@Table(name = "csv_model")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cid")
    private String cid;

    @Column(name = "voltage")
    private String voltage;

    @Column(name = "count")
    private String count;

    public CarModel() {
    }

    public CarModel(CSVCarModel csvCarModel){
        this.cid = csvCarModel.getCid();
        this.count = csvCarModel.getCount();
        this.voltage = csvCarModel.getVoltage();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
