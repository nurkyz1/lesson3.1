package com.geekcamp.lesson31.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {
    private  String id;
    private  String title;

    @SerializedName("original_title")
    private  String originalTitle;

    private String description;

    private String director;

    private List<String> people;

    @SerializedName("release_date")
    private  String releaseDate;

    private String producer;

    @SerializedName("running_time")
    private String runningTime;

    public String getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(String runningTime) {
        this.runningTime = runningTime;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Film(String id, String title, String originalTitle,
                String description, String director, List<String> people, String releaseDate) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.director = director;
        this.people = people;
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }
}
