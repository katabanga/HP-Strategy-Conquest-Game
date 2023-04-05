/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.duke.ece651.team16.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class App extends Application {
  public static MediaPlayer mediaPlayer;

  @Override
  public void start(Stage stage) {
    try {
      addMusic();
      URL xmlResource = getClass().getResource("/ui/StartGame.fxml");
      AnchorPane gp = FXMLLoader.load(xmlResource);
      Scene scene = new Scene(gp);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addMusic() {
    Media sound = new Media(getClass().getResource("/audio/Adventure.mp3").toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setAutoPlay(true);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    mediaPlayer.setStartTime(Duration.seconds(0));
    mediaPlayer.setStopTime(Duration.seconds(50));
    mediaPlayer.play();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

// public class App {
// public static Client client;

// public static void main(String[] args) throws IOException {
// int port = 1651;
// // String ip = "vcm-32174.vm.duke.edu";
// String ip = "127.0.0.1";
// Socket clientSocket = null;
// try {
// clientSocket = new Socket(ip, port);
// PrintStream out = System.out;
// BufferedReader inputReader = new BufferedReader(new
// InputStreamReader(System.in));
// BufferedReader socketReceive = new BufferedReader(new
// InputStreamReader(clientSocket.getInputStream()));
// PrintWriter socketSend = new PrintWriter(clientSocket.getOutputStream(),
// true);
// Client client = new Client(inputReader, out, socketReceive, socketSend);
// client.run();
// } catch (IOException e) {
// System.out.println("Failed to initialize Connection.");
// System.exit(1);
// } finally {
// if (clientSocket != null) {
// clientSocket.close();
// }
// }
// }
// }
