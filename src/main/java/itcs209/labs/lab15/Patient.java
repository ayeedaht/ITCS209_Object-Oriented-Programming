package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Patient implements FilePersistence{
    private int id;
    private String name;
    private String dateOfBirth;
    private char sex;
    private String address;

    public Patient(int id, String name, String dateOfBirth, char sex, String address) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOrBirth() {
        return dateOfBirth;
    }

    public void setDateOrBirth(String dateOrBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String displayPatient() {
        return "Patient code/name: "+id+" "+name+"\t"+"Sex: "+sex+"\t"+"Date of birth: "+dateOfBirth+"\n"+"Address: "+address;
    }

    @Override
    public void writeToFile(File outputFile) throws IOException {

    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {

    }
}
