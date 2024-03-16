package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Drug implements Display, FilePersistence{
    int code;
    String name;
    int amount;
    String unit;
    double price;

    public Drug(int code, String name, int amount, String unit, double price) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double computeSubTotal() {
        return Double.parseDouble(String.format("%.2f", amount * price));
    }

    public String toString() {
        return String.format("%5s %15s %18s %11s %10s",code,name,amount, unit,computeSubTotal());
    }


    @Override
    public void writeToFile(File outputFile) throws IOException {

    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {

    }
}
