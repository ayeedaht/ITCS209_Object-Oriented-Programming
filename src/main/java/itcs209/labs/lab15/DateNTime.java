package itcs209.labs.lab15;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.NoSuchElementException;

public class DateNTime implements FilePersistence{
    private LocalDate date;
    private LocalTime time;

    public DateNTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public String displayDate() {
        return String.format("%40s\n%102s", "Date: "+date, "Time: "+time);
    }

    @Override
    public void writeToFile(File outputFile) throws IOException {

    }

    @Override
    public void readFromFile(File inputFile) throws IOException, NoSuchElementException {

    }
}
