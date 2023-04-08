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
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class App extends Application {
  public static MediaPlayer mediaPlayer;

  @Override
  public void start(Stage stage) {
    try {
      addMusic();
      URL xmlResource = getClass().getResource("/ui/login.fxml");
      AnchorPane gp = FXMLLoader.load(xmlResource);

      CustomTab presetTab = new CustomTab(1, gp);
      TabPane tabPane = new TabPane();
      tabPane.getTabs().add(presetTab);

      Scene scene = new Scene(tabPane);
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

  private static class CustomTab extends Tab {
    private int tabNumber;
    private static int count = 1;

    public CustomTab(int tabNumber, AnchorPane content) {
      super();
      this.tabNumber = tabNumber;
      this.setContent(content);
      Label label = new Label("Risk Game " + tabNumber);
      Button addButton = new Button("+");
      addButton.setOnAction(e -> {
        try {
          URL xmlResource = getClass().getResource("/ui/login.fxml");
          AnchorPane gp = FXMLLoader.load(xmlResource);
          CustomTab newTab = new CustomTab(++count, gp);
          ((TabPane) this.getTabPane()).getTabs().add(newTab);
          ((TabPane) this.getTabPane()).getSelectionModel().select(newTab);
          addButton.setVisible(false);
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      });

      HBox hbox = new HBox(addButton, label);
      hbox.setAlignment(Pos.CENTER_LEFT);
      hbox.setSpacing(10);
      this.setGraphic(hbox);
    }
  }
}
