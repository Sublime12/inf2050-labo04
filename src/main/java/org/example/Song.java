package org.example;

public class Song {
    private String type;

    private String artist;

    private String title;

    private int publication;

    private int rating;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Song() {

    }

    public Song(String type, String artist, String title, int publication, int rating) {
        this.type = type;
        this.artist = artist;
        this.title = title;
        this.publication = publication;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Song{" +
                "type='" + type + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", publication=" + publication +
                ", rating=" + rating +
                '}';
    }
}
