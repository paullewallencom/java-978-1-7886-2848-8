package runner;

import car.ModularCar;
import carprocessor.ModularCarProcessor;
import csv.ModularCSVWriter;
import json.ModularJSONReader;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ApplicationRunner {
    public static void main(String args[]) throws IOException, ParseException {
        URL file_path = ApplicationRunner.class.getClassLoader().getResource("cars.json");

        ModularJSONReader jsonReader = new ModularJSONReader(file_path.getPath());
        List<ModularCar> cars = jsonReader.parseFile();

        ModularCarProcessor modularCarProcessor = new ModularCarProcessor(cars);
        List<ModularCar> fileredList = modularCarProcessor.processList("Ford", "Mercedes");

        ModularCSVWriter csvWriter = new ModularCSVWriter(new File("cars.csv").getAbsolutePath());
        csvWriter.writeToCSV(fileredList);
    }
}

