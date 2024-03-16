package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        File input = new File("C:\\Users\\mmay\\Desktop\\ITCS209\\GoodbyeOOP\\src\\main\\java\\itcs209\\labs\\lab15\\Input.txt");
        File output = new File("output.txt");
        IO out = new IO();
        out.writeToFile(output);
        out.readFromFile(input);
    }
}
