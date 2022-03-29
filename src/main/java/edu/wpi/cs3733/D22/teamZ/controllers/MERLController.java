package edu.wpi.cs3733.D22.teamZ.controllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.wpi.cs3733.D22.teamZ.App;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MERLController implements Initializable {

    // Each column on the main request list.
    @FXML private JFXTreeTableColumn<RequestRow, String> deviceColumn;
    @FXML private JFXTreeTableColumn<RequestRow, String> idColumn;
    @FXML private JFXTreeTableColumn<RequestRow, String> assigneeColumn;
    @FXML private JFXTreeTableColumn<RequestRow, String> statusColumn;

    // Table that lists all requests.
    @FXML private JFXTreeTableView requestTable;

    // Button that re-fetches requests and refreshes table.
    @FXML private JFXButton refreshButton;

    // Button that goes back to the default screen.
    @FXML private JFXButton backButton;

    // Buttons to select the sorting/filter parameters.
    @FXML private JFXButton assigneeButton;
    @FXML private JFXButton idButton;
    @FXML private JFXButton deviceButton;
    @FXML private JFXButton statusButton;

    // Drop-down box that selects which data type to filter by.
    @FXML private JFXComboBox<String> filterCBox;

    // Lists that display details about a selection.
    @FXML private JFXListView<Label> identifierList;
    @FXML private JFXListView dataList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] identifiers = {"ID", "Device", "Assignee", "Status"};

        for (int i = 0; i < 4; i++) {
            Label ID = new Label();
            ID.setText(identifiers[i]);
            identifierList.getItems().add(ID);
        }

        filterCBox.getItems().addAll("Test 1", "Test 2", "Test 3");

        idColumn.setCellValueFactory(
                new Callback<
                        TreeTableColumn.CellDataFeatures<RequestRow, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(
                            TreeTableColumn.CellDataFeatures<RequestRow, String> param) {
                        return param.getValue().getValue().id;
                    }
                });

        deviceColumn.setCellValueFactory(param -> param.getValue().getValue().device);
        assigneeColumn.setCellValueFactory(param -> param.getValue().getValue().assignee);
        statusColumn.setCellValueFactory(param -> param.getValue().getValue().status);

        ObservableList<RequestRow> requests = FXCollections.observableArrayList();
        requests.add(new RequestRow("1", "Device 1", "Dr. One", "Not Complete"));
        requests.add(new RequestRow("2", "Device 2", "Dr. Two", "Complete"));

        final TreeItem<RequestRow> root =
                new RecursiveTreeItem<>(requests, RecursiveTreeObject::getChildren);
        requestTable.setRoot(root);

        requestTable
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (obs, oldSelection, newSelection) -> {
                            RecursiveTreeItem<RequestRow> sel = (RecursiveTreeItem) newSelection;
                            System.out.println("Selected #" + sel.getValue().id.getValue());
                            loadRow(sel.getValue());
                        });
        requestTable.setShowRoot(false);
    }

    // Called whenever one of the filter buttons are clicked.
    public void filterClicked(ActionEvent event) {
        JFXButton buttonPressed = (JFXButton) event.getTarget();
        System.out.println(buttonPressed.getText());
    }

    // Called whenever the refresh button is clicked.
    public void refreshClicked(ActionEvent event) {
        System.out.println(refreshButton.getText());
    }

    // Called whenever the filter select was set?
    public void filterSet(ActionEvent event) {
        System.out.println(filterCBox.getSelectionModel().getSelectedItem());
    }

    // Called whenever the back button is clicked.
    public void backClicked() throws IOException {
        Stage mainStage = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(App.class.getResource("views/app.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
    }

    // Loads a RequestRow into the Details section.
    public void loadRow(RequestRow row) {
        dataList.getItems().clear();
        for (int i = 0; i < 4; i++) {
            Label data = new Label();
            switch (i) {
                case 0:
                    data.setText(row.id.getValue());
                    break;
                case 1:
                    data.setText(row.device.getValue());
                    break;
                case 2:
                    data.setText(row.assignee.getValue());
                    break;
                case 3:
                    data.setText(row.status.getValue());
                    break;
            }
            dataList.getItems().add(data);
        }
    }

    // Data structure to represent a row in the request list.
    // Does this belong here or in an entity?
    class RequestRow extends RecursiveTreeObject<RequestRow> {
        SimpleStringProperty id;
        SimpleStringProperty device;
        SimpleStringProperty assignee;
        SimpleStringProperty status;

        public RequestRow(String newId, String newDevice, String newAssignee, String newStatus) {
            id = new SimpleStringProperty(newId);
            device = new SimpleStringProperty(newDevice);
            assignee = new SimpleStringProperty(newAssignee);
            status = new SimpleStringProperty(newStatus);
        }
    }
}