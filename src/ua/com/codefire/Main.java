package ua.com.codefire;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String API_URL = "https://api.themoviedb.org/3/movie/popular?api_key=4022532d04dd400762f610a58169957b";

    public static String[] filmParametersNames = {
            "Original title: ",
            "Film rating: ",
            "Release date: ",
            "Tagline: ",
            "homepage: "
    };

    public static String[] filmParameters = {
            "original_title",
            "popularity",
            "release_date",
            "tagline",
            "homepage"
    };

    public static void main(String[] args) throws DeserializationException {
        StringBuilder buffer = new StringBuilder();

        try {
            // OPEN PAGE STREAM
            Scanner contentScan = new Scanner(new URL(API_URL).openStream());

            // BUFFER PAGE CONTENT
            while (contentScan.hasNextLine()) {
                String line = contentScan.nextLine();
                buffer.append(line).append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // GET BUFFERED STRING
        String jsonIncomingData = buffer.toString();

        /// POPULAR
        System.out.println("************************");
        System.out.println("TOP-20 Popular movies: ");
        System.out.println("************************");

        try {
            // DESERIALIZE
            JsonObject filmData = (JsonObject) Jsoner.deserialize(jsonIncomingData);
            // GET INNER ARRAY
            JsonArray results = (JsonArray) filmData.get("results");

            for (int i = 0; i < results.size(); i++) {
                // GET ARRAY #i OBJECT
                JsonObject filmObject = (JsonObject) results.get(i);

                // GET OBJECT INFO
                System.out.printf("%9s: %s\n", "Title", filmObject.getString("original_title"));
                System.out.printf("%9s: %.2f\n", "Rate", filmObject.getDouble("popularity"));
                System.out.printf("%9s: %s\n", "Release", filmObject.getString("release_date"));
                System.out.println();
            }
        } catch (DeserializationException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}