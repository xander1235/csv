package com.guru.csv.csvbind;
import com.opencsv.bean.CsvBindByName;

public class CSVCarModel {


    @CsvBindByName(required = true, column = "car_license_number")
    private String cid;

    @CsvBindByName(required = true, column = "count")
    private String count;

    @CsvBindByName(required = true, column = "voltage")
    private String voltage;

    public CSVCarModel() {
    }

    public CSVCarModel(String cid, String count, String voltage) {
        this.cid = cid;
        this.count = count;
        this.voltage = voltage;
    }

    public String getCid() {
        return cid;
    }



    public String getCount() {
        return count;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getVoltage() {
        return voltage;
    }

}
