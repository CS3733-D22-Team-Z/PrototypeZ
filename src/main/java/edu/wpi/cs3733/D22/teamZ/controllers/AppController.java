package edu.wpi.cs3733.D22.teamZ.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AppController {

  @FXML private Button exitButton; // ??????

  @FXML
  public void navMedicalEquipment(ActionEvent event) throws IOException {
    System.out.println("navigating to medical from default");
    Parent root =
        FXMLLoader.load(
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/MedicalEquipmentDelivery.fxml"));
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
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/LabServiceRequest.fxml"));
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
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/MedicineRequest.fxml"));
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
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/Meal Service.fxml"));
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
                .getResource("edu/wpi/cs3733/D22/teamZ/views/LanguageInterpreter.fxml"));
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
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/LaundryService.fxml"));
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
                .getResource("edu/wpi/cs3733/D22/teamZ/views/ComputerServiceRequest.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  @FXML
  public void toLocations(ActionEvent event) throws IOException {
    System.out.println("navigating to location from home");
    Parent root =
        FXMLLoader.load(
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/Location.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
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
    System.out.println("navigating to location from home");
    Parent root =
        FXMLLoader.load(
            getClass().getClassLoader().getResource("edu/wpi/cs3733/D22/teamZ/views/MERL.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void toHome(ActionEvent event) throws IOException {
    System.out.println("navigating to location from home");
    Parent root =
        FXMLLoader.load(
            getClass()
                .getClassLoader()
                .getResource("edu/wpi/cs3733/D22/teamZ/views/Homepage.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void toExit(ActionEvent event) {
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
  }
}
