package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Clinic implements FilePersistence{
    private String clinicName;
    private String streetName;
    private String cityName;
    private String zipCode;

    public Clinic(String clinicName, String streetName, String cityName, String zipCode) {
        this.clinicName = clinicName;
        this.streetName = streetName;
        this.cityName = cityName;
        this.zipCode = zipCode;
    }

    public String displayClinic() {
        return clinicName+"\n"+streetName+"\n"+cityName+" "+zipCode+"\n";
    }

    @Override
    public void writeToFile(File outputFile) throws IOException {

    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {

    }
}
