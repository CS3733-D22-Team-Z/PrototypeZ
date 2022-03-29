package edu.wpi.cs3733.D22.teamZ.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class medicineRequestController {
  @FXML private Label label;

  @FXML
  private void backToDashboard(ActionEvent event) throws IOException {
    Parent root =
        FXMLLoader.load(getClass().getClassLoader().getResource("edu/wpi/teamZ/views/app.fxml"));
    Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
