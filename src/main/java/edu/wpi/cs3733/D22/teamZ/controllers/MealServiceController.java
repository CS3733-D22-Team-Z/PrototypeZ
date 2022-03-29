package edu.wpi.cs3733.D22.teamZ.controllers;

import edu.wpi.cs3733.D22.teamZ.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MealServiceController {
  @FXML private Button backButton;
  @FXML private Button mealButton;

  @FXML
  void backToDashboard() throws IOException {
    Stage primaryStage = (Stage) backButton.getScene().getWindow();
    Parent root = FXMLLoader.load(App.class.getResource("views/app.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
  }
}
