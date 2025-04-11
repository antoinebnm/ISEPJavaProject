package project.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class FileManager {
    private final String cheminFichier;
    private final Gson gson;

    public FileManager(String cheminFichier) {
        this.cheminFichier = cheminFichier;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        initFileIfNotExists();
    }

    private void initFileIfNotExists() {
        File file = new File(cheminFichier);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("{}"); // fichier vide JSON
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> T lire(Class<T> clazz) {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T> void ecrire(T objet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            gson.toJson(objet, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}