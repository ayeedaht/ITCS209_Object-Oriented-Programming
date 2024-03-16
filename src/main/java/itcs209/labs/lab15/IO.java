package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IO implements  FilePersistence {
    private Scanner in;
    private PrintWriter out;
    @Override
    public void writeToFile(File outputFile) throws IOException {
        out = new PrintWriter(outputFile);
    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {
        Prescription pcp = new Prescription(new Clinic("IHC Hospital", "101 Daehak-ro, Yeongeon-dong,", "Jongno-gu, Seoul,", "Seoul 03080"), new Patient(12859, "Yoon Jin-young", "1999-08-11", 'M', "37 Gukjegeumyung-ro 2-gil Yeongdeungpo-gu Seoul, Seoul, South Korea 07327"), new DateNTime(LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)));
        in = new Scanner(inputFile);

        int id2 = 0;
        String name = null;
        char sex2 = 0;
        String birth = null;
        String line3 = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() == 0) {
                break;
            }

            String[] splitLine = line.split(",");
            String id = splitLine[0];
            id2 = Integer.parseInt(id);
            name = splitLine[1];
            String sex = splitLine[2];
            birth = splitLine[3];
            sex2 = sex.charAt(1);
            line3 = in.nextLine();
        }

        int code = 0;
        String drug0 = null;
        int drug1_2 = 0;
        String drug2 = null;
        double price = 0;
        while (in.hasNextLine()) {
            String line2 = in.nextLine();
            String[] splitLine = line2.split(", ");
            drug0 = splitLine[0];
            String drug1 = splitLine[1];
            drug1_2 = Integer.parseInt(drug1);
            drug2 = splitLine[2];
            code = 0;
            price = 0;

            switch (drug0) {
                case "Aspirin" -> {
                    code = 2389;
                    price = 1.19;
                }
                case "Amoxicillin" -> {
                    code = 5193;
                    price = 4.00;
                }
                case "Alcohol 77% Food Grade 20 ml" -> {
                    code = 8587;
                    price = 39.00;
                }
                case "Cetirizine" -> {
                    code = 1068;
                    price = 0.60;
                }
                case "Multivitamin Orange" -> {
                    code = 4855;
                    price = 7.25;
                }
                case "Nasal Spray" -> {
                    code = 2329;
                    price = 177.00;
                }
                case "Paracetamol" -> {
                    code = 1026;
                    price = 0.32;
                }
                case "Steam Inhalation" -> {
                    code = 3179;
                    price = 9.90;
                }
                case "STREPSILS COOL" -> {
                    code = 3603;
                    price = 4.87;
                }
                case "Vitamin" -> {
                    code = 2100;
                    price = 1.00;
                }
            }
            pcp.addLineDrug(code, drug0, drug1_2, drug2, price);
        }

        pcp.setC(new Clinic("IHC Hospital", "101 Daehak-ro, Yeongeon-dong,", "Jongno-gu, Seoul,", "Seoul 03080"));
        pcp.setP(new Patient(id2, name, birth, sex2, line3));
        out.println("-----------------------------------------------------------------------------");
        out.println(pcp.toString());
        out.println("-----------------------------------------------------------------------------");
        out.format("%50s %11s %7s", "The total amount", pcp.computeAmountDue(), "BATH\n");
        out.format("%52s %9s %7s", "Expenses insurance", pcp.computeInsurance(), "BATH\n");
        out.format("%47s %14s %7s", "Total payment", pcp.totalPayment(), "BATH\n");

        in.close();
        out.close();
    }
}


/**
 pcp.addLineDrug(2389,"Aspirin",20,"TAB",1.19);
 pcp.addLineDrug(5193,"Amoxicillin",42,"CAP",4.00);
 pcp.addLineDrug(8587,"Alcohol 77% Food Grade 20 ml",1,"SPRAY",39.00);
 pcp.addLineDrug(1068,"Cetirizine",7,"CAP",0.60);
 pcp.addLineDrug(4855,"Multivitamin Orange",20,"TAB",7.25);
 pcp.addLineDrug(2329,"Nasal Spray",1,"SPRAY",177.00);
 pcp.addLineDrug(1026,"Paracetamol",20,"TAB",0.32);
 pcp.addLineDrug(3179,"Steam Inhalation",10,"CAP",9.90);
 pcp.addLineDrug(3603,"STREPSILS COOL",8,"TAB",4.87);
 pcp.addLineDrug(2100,"Vitamin",20,"TAB",1.00);
 System.out.println("-----------------------------------------------------------------------------");
 System.out.println(pcp.toString());
 System.out.println("-----------------------------------------------------------------------------");
 System.out.format("%50s %11s %7s","The total amount",pcp.computeAmountDue(),"BATH\n");
 System.out.format("%52s %9s %7s","Expenses insurance",pcp.computeInsurance(),"BATH\n");
 System.out.format("%47s %14s %7s","Total payment",pcp.totalPayment(),"BATH\n");
 **/

