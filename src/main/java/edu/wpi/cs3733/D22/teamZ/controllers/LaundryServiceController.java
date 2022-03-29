package edu.wpi.cs3733.D22.teamZ.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LaundryServiceController {

  public void navDefault(javafx.event.ActionEvent actionEvent) throws IOException {
    Parent root =
        FXMLLoader.load(getClass().getClassLoader().getResource("edu/wpi/teamZ/views/app.fxml"));
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
