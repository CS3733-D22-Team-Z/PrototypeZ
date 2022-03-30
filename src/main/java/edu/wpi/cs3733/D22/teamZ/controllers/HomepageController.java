package edu.wpi.cs3733.D22.teamZ.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.*;

public class HomepageController {
  @FXML private Label label;
  @FXML private Button exitButton; // ??????

  @FXML
  public void toLocations(ActionEvent event) throws IOException {
    Parent root =
        FXMLLoader.load(
            getClass().getClassLoader().getResource("edu/wpi/cs3733/D22/teamZ/views/app.fxml"));
    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void toLandingPage(ActionEvent event) throws IOException {
    Parent root =
        FXMLLoader.load(
            getClass().getClassLoader().getResource("edu/wpi/cs3733/D22/teamZ/views/app.fxml"));
    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void toMedicalEquipmentRequest(ActionEvent event) throws IOException {
    Parent root =
        FXMLLoader.load(
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/app.fxml"));
    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
    // button.setWrapText(true);
  }

  public void toHome(ActionEvent event) throws IOException {
    Parent root =
        FXMLLoader.load(
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/Homepage.fxml"));
    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public void toExit(ActionEvent event) {
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
  }
}
// Link to location, Landing, & Medical Equipment Page
// Test the exit button
// Fix wrap text method
