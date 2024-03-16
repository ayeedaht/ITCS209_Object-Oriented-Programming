package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Prescription implements Display, FilePersistence {
    ArrayList<Drug> input = new ArrayList<Drug>();
    private Clinic c;
    private Patient p;
    private DateNTime d;

    public Prescription(Clinic c, Patient p, DateNTime d) {
        this.c = c;
        this.p = p;
        this.d = d;
    }

    void  addLineDrug(int code, String name, int amount, String unit, double price) {
        input.add(new Drug(code, name, amount, unit, price));
    }

    public void setC(Clinic c) {
        this.c = c;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public String computeAmountDue() {
        double Total = 0;
        for (int i = 0; i < input.size(); i++) {
            Total += input.get(i).computeSubTotal();
        }
        String tt = String.format("%.2f", Total);
        return tt;
    }

    public String computeInsurance() {
        double insurancePaid = 0;
        double insurance = 0;
        for (int i = 0; i < input.size(); i++) {
            insurancePaid += (input.get(i).computeSubTotal());
            insurance = insurancePaid * 30 / 100;
        }
        String ip = String.format("%.2f", insurance);
        return ip;
    }

    public String totalPayment() {
        double pay = Double.parseDouble(computeAmountDue());
        double finalPay = Double.parseDouble(computeInsurance());
        String paid = String.format("%.2f", pay - finalPay);
        return paid;
    }

    public String toString() {
        String output = new String();
        output += c.displayClinic()+"\n"+p.displayPatient()+"\t"+d.displayDate();
        output += String.format("\n%5s %20s %15s %10s %10s\n-----------------------------------------------------------------------------\n", "NDC", "List", "Amount", "Unit", "Price");
        for (int i = 0; i < input.size(); i++) {
            output += input.get(i).toString()+"\n";
        } return output;
    }

    @Override
    public void writeToFile(File outputFile) throws IOException {

    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {

    }
}
