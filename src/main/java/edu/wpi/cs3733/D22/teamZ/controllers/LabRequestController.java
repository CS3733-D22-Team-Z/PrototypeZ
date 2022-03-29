package edu.wpi.cs3733.D22.teamZ.controllers;

import com.jfoenix.controls.JFXButton;
import edu.wpi.cs3733.D22.teamZ.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LabRequestController {
    @FXML private JFXButton backButton;

    @FXML
    public void onBackButtonClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(App.class.getResource("views/app.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }
}
