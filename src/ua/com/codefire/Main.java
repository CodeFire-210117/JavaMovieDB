package ua.com.codefire;

import java.util.ArrayList;

public class Main {

    private static final String API_URL = "https://api.themoviedb.org/3/movie/popular?api_key=4022532d04dd400762f610a58169957b";

    public static void main(String[] args) {

        MovieDBLoader dbLoader = new MovieDBLoader();
        ArrayList<Film> arrayList = dbLoader.loadPopular(2);

        for (Film film : arrayList) {
            // GET OBJECT INFO
            System.out.printf("%1$9s: %5$d\n%2$9s: %6$s\n%3$9s: %7$s\n%4$9s: %8$.2f\n\n",
                    "ID",
                    "Title",
                    "Release",
                    "Rate",
                    film.getId(),
                    film.getOriginTitle(),
                    film.getReleaseDate(),
                    film.getVoteAverage());
        }

    }
}