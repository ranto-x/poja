package ranto.co.io.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

@RestController
public class StoredIntController {

  private static final String FILE_PATH = System.getProperty("java.io.tmpdir") + File.separator + "stored-int.txt";

  @GetMapping("/stored-int")
  public String getStoredInt() {
    File file = new File(FILE_PATH);
    try {
      if (file.exists()) {
        String content = Files.readString(file.toPath());
        return "Valeur existante : " + content;
      } else {
        int randomInt = new Random().nextInt(1000);
        try (FileWriter writer = new FileWriter(file)) {
          writer.write(String.valueOf(randomInt));
        }
        return "Fichier créé avec : " + randomInt;
      }
    } catch (IOException e) {
      return "Erreur : " + e.getMessage();
    }
  }
}
