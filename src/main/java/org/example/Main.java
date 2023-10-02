package org.example;

import net.sf.ezmorph.test.ArrayAssertions;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        var jsonObject = JSONObject.fromObject("collection.json");

        try {
//            var file = new File("collection.json");
//            ;

            var collectionTxt = Files.readString(Path.of("collection.json"));
//            System.out.println(collectionTxt);
            JSONObject object = JSONObject.fromObject(collectionTxt);
            var collectionArray = object.getJSONArray("collection");
//            System.out.println(collectionArray.toString());

            ArrayList<Song> songs = mapToSongs(collectionArray);

            System.out.println("Le nombre d'albums est : " + nombreAlbums(songs));
            System.out.println("Le nombre des singles est : " + nombreSingles(songs));

            System.out.println("La liste des albums depuis 2023 est : ");
            for (var song : nombreAlbums2003(songs)) {
                System.out.println("Titre: " + song.getTitle() + ", Publication: " + song.getPublication());
            }


        } catch (IOException e) {
            System.out.println("Le fichier collection.json n'existe pas");
            return;
        }
    }

    private static ArrayList<Song> nombreAlbums2003(ArrayList<Song> songs) {
        var returnSongs = new ArrayList<Song>();

        for (var song : songs) {
            if (song.getType().equals("album") && song.getPublication() >= 2003) returnSongs.add(song);
        }

        return returnSongs;
    }

    public static int nombreAlbums(ArrayList<Song> songs) {
        int nbAlbums = 0;

        for (var song : songs) {
            if (song.getType().equals("album")) nbAlbums++;
        }

        return nbAlbums;
    }

    public static int nombreSingles(ArrayList<Song> songs) {
        int nbSingle = 0;

        for (var song : songs) {
            if (song.getType().equals("single")) nbSingle++;
        }

        return nbSingle;
    }

    public static ArrayList<Song> mapToSongs(JSONArray collectionNode) {
        var songs = new ArrayList<Song>();

//        Construire ArrayList<Song>
        for (int i = 0; i < collectionNode.size(); i++) {
            var songNode = collectionNode.getJSONObject(i);
            var song = new Song();

            song.setType(songNode.getString("type"));
            song.setArtist(songNode.getString("artist"));
            song.setTitle(songNode.getString("title"));
            song.setPublication(songNode.getInt("publication"));
            song.setRating(songNode.getInt("rating"));

            songs.add(song);
        }

        return songs;
    }
}