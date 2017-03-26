package ua.com.codefire;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by human on 3/26/17.
 */
public final class MovieDBLoader {

    private static final String API_URL = "https://api.themoviedb.org/3/movie/popular?api_key=4022532d04dd400762f610a58169957b";

    /**
     * @param page
     * @return
     */
    public ArrayList<Film> loadPopular(int page) {
        StringBuilder buffer = new StringBuilder();

        // OPEN PAGE STREAM
        String address = String.format("%s&page=%d", API_URL, page);

        try (Scanner contentScan = new Scanner(new URL(address).openStream())) {
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

        ArrayList<Film> filmList = new ArrayList<>();

        try {
            // DESERIALIZE
            JsonObject filmData = (JsonObject) Jsoner.deserialize(jsonIncomingData);
            // GET INNER ARRAY
            JsonArray results = (JsonArray) filmData.get("results");

            for (int i = 0; i < results.size(); i++) {
                // GET ARRAY #i OBJECT
                JsonObject filmObject = (JsonObject) results.get(i);

                Long id = filmObject.getLong("id");
                String original_title = filmObject.getString("original_title");
                Double vote_avarage = filmObject.getDouble("vote_average");
                LocalDate release_date = LocalDate.parse(filmObject.getString("release_date"));

                filmList.add(new Film(id, original_title, vote_avarage, release_date));
            }
        } catch (DeserializationException e) {
            e.printStackTrace();
            e.printStackTrace();
        }

        return filmList;
    }

}
