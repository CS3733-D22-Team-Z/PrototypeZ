package edu.wpi.cs3733.D22.teamZ.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {

    @FXML
    public void navMedicalEquipment(ActionEvent event) throws IOException {
        System.out.println("navigating to medical from default");
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getClassLoader()
                                .getResource("edu/wpi/teamZ/views/MedicalEquipmentDelivery.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navLab(ActionEvent event) throws IOException {
        System.out.println("navigating to lab from default");
        Parent root =
                FXMLLoader.load(
                        getClass().getClassLoader().getResource("edu/wpi/teamZ/views/LabServiceRequest.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navMedicine(ActionEvent event) throws IOException {
        System.out.println("navigating to medicine from default");
        Parent root =
                FXMLLoader.load(
                        getClass().getClassLoader().getResource("edu/wpi/teamZ/views/MedicineRequest.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navMeal(ActionEvent event) throws IOException {
        System.out.println("navigating to meal from default");
        Parent root =
                FXMLLoader.load(
                        getClass().getClassLoader().getResource("edu/wpi/teamZ/views/Meal Service.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navLanguage(ActionEvent event) throws IOException {
        System.out.println("navigating to language from default");
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getClassLoader()
                                .getResource("edu/wpi/teamZ/views/LanguageInterpreter.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navLaundry(ActionEvent event) throws IOException {
        System.out.println("navigating to laundry from default");
        Parent root =
                FXMLLoader.load(
                        getClass().getClassLoader().getResource("edu/wpi/teamZ/views/LaundryService.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void navComputer(ActionEvent event) throws IOException {
        System.out.println("navigating to computer from default");
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getClassLoader()
                                .getResource("edu/wpi/teamZ/views/ComputerServiceRequest.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
