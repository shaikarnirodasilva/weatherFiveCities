package Skau.kds;

import com.shay.weather.City;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANDROID on 26/07/2017.
 */
public class FileUtils {
    public static boolean fileExist(String filePath) {
        File f = new File(filePath);
        if (f.exists()) {
            return true;
        } else
            return false;
    }

//Do while tnai when you do it then you give tnai and if its y get in again.
    //Adds to TXT and the file.

    public static void writeCities(String filePath, List citiesList, boolean overWrite) throws IOException {
        if (citiesList.size() > 0) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            FileWriter fileWriter = new FileWriter(filePath);

            for (int i = 0; i < citiesList.size(); i++) {
                fileWriter.write(citiesList.get(i).toString());
                fileWriter.write("\n");
                writer.write(citiesList.get(i).toString());
                writer.newLine();
            }
            writer.close();
        }

    }


    public static void changeCities(String filePath, Integer numOfCities, boolean overWrite) throws IOException {
        if (!(fileExist(filePath)) || (fileExist(filePath) && overWrite)) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            FileWriter fileWriter = new FileWriter(filePath);

            System.out.println("Please Enter a City Name :");
            for (int i = 0; i < numOfCities; i++) {
                writer.write(IO.nextString("City" + (i + 1) + ":"));
                writer.newLine();
            }


            writer.close();
        }

    }


    //Delete 1 City


    //Writes it to a txt List From OutSide.
    public static List<String> readCitiesToList(String fileName) throws IOException {
        String result;
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            while ((result = reader.readLine()) != null) {
                fileLines.add(result);
            }
            return fileLines;
        }
    }

}

