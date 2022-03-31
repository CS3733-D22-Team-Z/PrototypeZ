package edu.wpi.cs3733.D22.teamZ.controllers;

import com.jfoenix.controls.JFXButton;
import edu.wpi.cs3733.D22.teamZ.*;
import edu.wpi.cs3733.D22.teamZ.App;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MedicalEquipmentDelivery {
  private LocationDAOImpl il1 = new LocationDAOImpl();
  private MedEquipReqDAOImpl im1 = new MedEquipReqDAOImpl();

  @FXML private JFXButton backButton;
  @FXML private JFXButton resetButton;
  @FXML private JFXButton submitButton;

  @FXML private Label header;
  @FXML private Label objectBodyText;
  @FXML private Label roomNumberLabel;
  @FXML private Label equipmentLabel;
  @FXML private TextField enterRoomNumber;
  @FXML private TextField enterFloorNumber;
  @FXML private TextField enterNodeType;
  @FXML private TextField enterStaffAssigned;
  @FXML private ChoiceBox equipmentDropDown;
  @FXML private ChoiceBox statusDropDown;

  private ObservableList<Location> locationList;
  private ObservableList<MedEquipReq> equipmentList;

  //  MedicalEquipmentDeliveryRequest oneRequest =

  //  try {
  //    data =
  //    // Execute query and store result in a resultset
  //    ResultSet rs = conn.createStatement().executeQuery("SELECT username FROM user WHERE
  // userrole='STUDENT';");
  //    while (rs.next()) {
  //      //get string from db,whichever way
  //      data.add(new User(rs.getString("username")));
  //    }
  //  } catch (SQLException ex) {
  //    System.err.println("Error"+ex);
  //  }

  @FXML
  public void initialize() {
    locationList = FXCollections.observableList(il1.getAllLocations());
    equipmentList = FXCollections.observableList(im1.getAllMedEquipReq());

    //    locationList = il1.getAllLocations();
    //    System.out.println("locationList");
    //    System.out.println(locationList);
    //    System.out.println();
    //    System.out.println("Test");
    for (Location model : locationList) {
      System.out.println(model.getNodeID());
    }

    // examples
    equipmentDropDown.setItems(FXCollections.observableArrayList("Bed", "IV", "Pillow"));
    statusDropDown.setItems(FXCollections.observableArrayList("Pending", "Approved", "Denied"));
    statusDropDown.setValue("Pending");
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
    enterFloorNumber.clear();
    enterNodeType.clear();
    enterStaffAssigned.clear();
    equipmentDropDown.setValue(null);
    statusDropDown.setValue(null);
  }

  @FXML
  public void onSubmitButtonClicked(ActionEvent actionEvent) {
    System.out.println("Room Number: " + enterRoomNumber.getText());
    System.out.println("Floor Number: " + enterFloorNumber.getText());
    System.out.println("nodeType: " + enterNodeType.getText());
    System.out.println("staff assigned: " + enterStaffAssigned.getText());
    System.out.println("Equipment Selected: " + equipmentDropDown.getValue());
    System.out.println("Status Selected: " + statusDropDown.getValue());

    MedEquipReq lastestReq = equipmentList.get(equipmentList.size() - 1);
    String id = lastestReq.getRequestID();
    int num = 1 + Integer.parseInt(id.substring(id.lastIndexOf("Q") + 1));
    MedEquipReq temp = new MedEquipReq();
    temp.setRequestID("REQ" + num);

    temp.setStatus("Processing"); // default
    temp.setEquipment(equipmentDropDown.getValue().toString());
    temp.setHandler("Jake"); // temp
    temp.setIssuer(enterStaffAssigned.getText());
    temp.setCurrentLoc("zDEPT00101"); // temp

    /**
     * Example: zDEPT00101 z as lowercase team letter DEPT as nodeType 001 as Room Number 01 as
     * floor number (L2, L1, 01, 02, 03)
     */
    String target =
        "z" + enterNodeType.getText() + enterRoomNumber.getText() + enterFloorNumber.getText();
    temp.setTargetLoc(target);

    im1.addMedEquipReq(temp);
  }

  @FXML
  private void validateButton() {
    if (!enterRoomNumber.getText().trim().isEmpty()
        && !enterFloorNumber.getText().trim().isEmpty()
        && !enterNodeType.getText().trim().isEmpty()
        && !enterStaffAssigned.getText().trim().isEmpty()
        && !equipmentDropDown.getSelectionModel().isEmpty()
        && !statusDropDown.getSelectionModel().isEmpty()) {
      submitButton.setDisable(false);
    } else {
      submitButton.setDisable(true);
    }
  }
}
