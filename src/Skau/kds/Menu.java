package Skau.kds;

import com.google.gson.Gson;
import com.shay.weather.WeatherResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Skau.kds.FileUtils.*;

public class Menu {

    Menu() throws IOException {

        String fileName = "Cities.txt";
        fileExist(fileName);
        List<String> citiesList = new ArrayList<>();
        int userChoice;


        try {
            writeCities(fileName, citiesList, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Menu
        do {
            System.out.println("Please Choose One Of The Options:");
            System.out.printf("\n%3d ) Add City", (1));
            System.out.printf("\n%3d ) Delete City \n", (2));
            System.out.printf("%3d ) Exit \n", (3));


            for (int i = 0; i < citiesList.size(); i++) {
                System.out.printf("%3d ) %s\n", (i + 4), citiesList.get(i));
            }


            userChoice = IO.nextInt("\nPlease Make a Choice:");

            String city = "";
            if (userChoice != 3)
                switch (userChoice) {
                    case 1:
                        //Add City
                        city = IO.nextLine("Enter The Name Of The City You Want To Add:");
                        citiesList.add(city);
                        writeCities("cities.txt", citiesList, true);
                        break;
                    case 2:
                        //Delete City
                        int cityNum = IO.nextInt("Enter The Number Of The City You Want To Delete:");
                        citiesList.remove(cityNum - 4);
                        writeCities("Cities.txt", citiesList, false);
                        break;
//Cities Names:
                    case 3:
                        System.out.println("Exiting the system");
                        System.exit(0);
                        break;

                    case 4:
                        city = citiesList.get(0);
                        getCity(city);
                        break;
                    case 5:
                        city = citiesList.get(1);
                        getCity(city);
                    case 6:
                        city = citiesList.get(2);
                        getCity(city);
                        break;
                    case 7:
                        city = citiesList.get(3);
                        getCity(city);
                        break;
                    //Exit
                    case 8:
                        city = citiesList.get(4);
                        getCity(city);
                        break;
                    case 9:
                        city = citiesList.get(5);
                        getCity(city);
                        //Wrong choice
                    default:
                        System.out.println("Choice not found!!! Choose between 1-10:");
                        break;
                }

        } while (userChoice != 3);
    }

    //EXIT


    static void getCity(String cityName) {
        String api1 = "http://api.openweathermap.org/data/2.5/forecast?appid=0cd0b52c786c9ee6e1ce3a25f701d14d&q=";
        String city = cityName;
        String apiPart3 = ",il&units=metric";

        String address = api1 + city + apiPart3;
        try {
            //get the json from the web as String
            String json = HTTPUtils.read(address);
            //use gson
            Gson gson = new Gson();
            //use gson to convert the json to JAVA
            //now you got a JAVA Object.
            //this object is WeatherResult:
            WeatherResult weatherResult = gson.fromJson(json, WeatherResult.class);
            List<com.shay.weather.List> list = weatherResult.getList();

            for (com.shay.weather.List item : list) {
                System.out.println(item.getDtTxt());
                System.out.println(item.getWeather().get(0).getDescription());
                System.out.println(item.getMain().getTemp());
                System.out.println(item.getMain().getHumidity());
                System.out.println("____________________________________");
            }

            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(city);
    }
}






