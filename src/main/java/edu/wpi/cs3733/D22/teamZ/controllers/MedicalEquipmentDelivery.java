package edu.wpi.cs3733.D22.teamZ.controllers;

import com.jfoenix.controls.JFXButton;
import edu.wpi.cs3733.D22.teamZ.App;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MedicalEquipmentDelivery {
    @FXML private JFXButton backButton;
    @FXML private JFXButton resetButton;
    @FXML private JFXButton submitButton;
    @FXML private Label header;
    @FXML private Label objectBodyText;
    @FXML private Label roomNumberLabel;
    @FXML private Label equipmentLabel;
    @FXML private TextField enterRoomNumber;
    @FXML private ChoiceBox equipmentDropDown;

    @FXML
    public void initialize() {
        equipmentDropDown.setItems(FXCollections.observableArrayList("Bed", "IV", "Pillow"));
    }

    @FXML
    public void onBackButtonClicked(ActionEvent event) throws IOException {
        Stage mainStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(App.class.getResource("views/app.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
    }

    @FXML
    public void onResetButtonClicked(ActionEvent event) throws IOException {
        enterRoomNumber.clear();
        equipmentDropDown.setValue(null);
    }

    public void onSubmitButtonClicked(ActionEvent actionEvent) {
        System.out.println("Room Number: " + enterRoomNumber.getText());
        System.out.println("Equipment Selected: " + equipmentDropDown.getValue());
    }
}
