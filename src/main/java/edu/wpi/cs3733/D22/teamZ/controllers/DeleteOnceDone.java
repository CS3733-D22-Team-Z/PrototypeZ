package edu.wpi.cs3733.D22.teamZ.controllers;

import edu.wpi.cs3733.D22.teamZ.*;

import java.io.*;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

// issues: getAllLocations doesn't work if the DB is disconnected, is this how it's supposed to
// work?

// LocationController controls Location.fxml, loads location data into a tableView on page
public class DeleteOnceDone {

    //test
    // init ui components
    @FXML private TableView<MedEquipReq> MedRequestsTable;
    @FXML private TableColumn<MedEquipReq, String> requestIDCol;
    @FXML private TableColumn<MedEquipReq, String> statusCol;
    @FXML private TableColumn<MedEquipReq, String> issuerCol;
    @FXML private TableColumn<MedEquipReq, String> handlerCol;
    @FXML private TableColumn<MedEquipReq, String> equipmentCol;
    @FXML private TableColumn<MedEquipReq, String> currentLocCol;
    @FXML private TableColumn<MedEquipReq, String> targetLocCol;
    @FXML private Button loadData;

    // init MedEquipReqDAOImpl
    IMedEquipReqDAO medDAO = new MedEquipReqDAOImpl();

    // create ObservableList to load MedEquipDAO into tableView
    private ObservableList<MedEquipReq> data;

    // loadDataFromDatabase when button loadData is clicked
    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        System.out.println("loading data");
        MedRequestsTable.setItems(null);

        // get list of locations from db and transfer into ObservableList
        data = FXCollections.observableList(medDAO.getAllMedEquipReq());

        // link columnNames to data
        requestIDCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("requestID"));
        statusCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("status"));
        issuerCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("issuer"));
        handlerCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("handler"));
        equipmentCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("equipment"));
        currentLocCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("currentLoc"));
        targetLocCol.setCellValueFactory(new PropertyValueFactory<MedEquipReq, String>("targetLoc"));

        // load data into tableView

        MedRequestsTable.setItems(data);
    }

    @FXML
    public void writeExcel(ActionEvent event) throws Exception {
        System.out.println("exporting CSV of LocationData");
        data = FXCollections.observableList(medDAO.getAllMedEquipReq());
    }

    @FXML
    public void navHome(ActionEvent event) throws IOException {
        System.out.println("navigating to home from locations");
        Parent root =
                FXMLLoader.load(
                        getClass()
                                .getClassLoader()
                                .getResource("edu/wpi/cs3733/D22/teamZ/views/HomePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
