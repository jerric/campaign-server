package net.lliira.game.campaign;

import java.io.File;
import java.net.MalformedURLException;

/** Hello world! */
public class App {
  public static void main(String[] args) {
    try {
      System.out.println(new File("file:./game-compaign.properties").toURI().toURL());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
