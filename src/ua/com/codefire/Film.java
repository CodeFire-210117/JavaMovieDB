package ua.com.codefire;

import java.time.LocalDate;

/**
 * Created by human on 3/26/17.
 */
public class Film {

    private long id;
    private String originTitle;
    private double voteAverage;
    private LocalDate releaseDate;

    public Film(long id, String originTitle, double voteAverage, LocalDate releaseDate) {
        this.id = id;
        this.originTitle = originTitle;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", originTitle='" + originTitle + '\'' +
                ", voteAverage=" + voteAverage +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
