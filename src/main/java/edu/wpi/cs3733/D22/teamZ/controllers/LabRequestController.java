package edu.wpi.cs3733.D22.teamZ.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.wpi.cs3733.D22.teamZ.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabRequestController implements Initializable {
  // Formatting string for inserting the lab type into the contextual information section.
  private String defaultCTXString = "%s Required Information";

  @FXML private JFXButton backButton;
  @FXML private ChoiceBox<String> labTypeChoiceBox;
  @FXML private ChoiceBox<String> roomChoiceBox;
  @FXML private TextField patientNameTextField;
  @FXML private TextField patientIDTextField;
  @FXML private Label contextSection;
  @FXML private Canvas timeCanvas;
  @FXML private Slider timeSlider;

  // The graphics context for the time canvas.
  private GraphicsContext timeDraw;

  // The colors used in the timeCanvas
  private Color[] timeColors = {Color.WHITE, Color.DARKGRAY};

  // The amount of subsections the time canvas will have
  int nSections = 6;

  // Size of font used for timeCanvas
  int fontSize = 10;
  // Note: This should probably be temporary
  int fontWidth = 5;

  // Amount of padding on left and right to center time
  int padding = 25;

  // Get the dimensions of one subsection
  // Workable space will be the width of the canvas minus the padding for text.
  double subWidth;
  double subHeight;

  // Get the current position of the line
  int linePos = 0;

  // Initialization code for the Lab Request Page
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Get subsection height and width properties
    subWidth = (timeCanvas.getWidth() - padding * 2) / nSections;
    subHeight = timeCanvas.getHeight();

    // Save graphics context for use in other areas of the controller.
    timeDraw = timeCanvas.getGraphicsContext2D();
    initCanvas();

    // Link onValueChanged to timeSelected
    timeSlider
            .valueProperty()
            .addListener(
                    (observable, oldValue, newValue) -> {
                      timeSelected();
                    });
  }

  // Setup the time canvas
  public void initCanvas() {
    // Set the font of the time canvas
    timeDraw.setFont(new Font(fontSize));

    // Draw timestamp for each box.
    for (int i = 0; i <= nSections; i++) {
      timeDraw.setFill(Color.BLACK);

      String timeLabel = formatTime(i);
      // Get the width of the string displayed
      double labelWidth = timeLabel.length() * fontWidth;

      // Draw the text centered. It simply begins at the bottom left corner of a subsection, and
      // shifts it left by half its length.
      timeDraw.fillText(formatTime(i), padding + subWidth * i - labelWidth / 2, subHeight);
    }

    updateCanvas();
  }

  // Update the canvas every time something new will be drawn.
  public void updateCanvas() {
    // Draw all subsections, each with an alternating color
    for (int i = 0; i < nSections; i++) {
      timeDraw.setFill(timeColors[i % 2]);
      timeDraw.fillRect(padding + subWidth * i, 0, subWidth, subHeight - fontSize);
    }
    // Depending on the value, draw a line on canvas
    timeDraw.setStroke(Color.RED);
    timeDraw.setLineWidth(2.5f);

    // Set line to left edge of subsection
    timeDraw.moveTo(padding + 1.25 + subWidth * linePos, 0);
    timeDraw.lineTo(padding + 1.25 + subWidth * linePos, subHeight - fontSize - 1.25);

    // Draw
    timeDraw.stroke();
  }

  // Return a formatted time, given the hour.
  public String formatTime(int hour) {
    // Convert to 12 hour time
    int nTime = hour % 12;

    // If 0, then it is at 12 hour time.
    if (nTime == 0) nTime = 12;

    // See whether or not it is AM or PM
    String APM = hour > 12 ? "PM" : "AM";

    // Return formatted time
    return String.format("%d:00 %s", nTime, APM);
  }

  @FXML
  public void onBackButtonClicked(ActionEvent event) throws IOException {
    // Load the default FXML file and set that scene to the main stage.
    Stage mainStage = (Stage) backButton.getScene().getWindow();
    Parent root = FXMLLoader.load(App.class.getResource("views/app.fxml"));
    Scene scene = new Scene(root);
    mainStage.setScene(scene);
  }

  // Whenever the lab type choice box is changed, this function is executed.
  @FXML
  public void labTypeChanged() {
    // Get the value of the choice box.
    String selectedValue = labTypeChoiceBox.getSelectionModel().getSelectedItem();

    // If non-empty, format the contextual information section's title with the lab type.
    // Also null-check, since value will be null rather than an empty string.
    if (selectedValue != null && !selectedValue.isEmpty()) {
      contextSection.setText(String.format(defaultCTXString, selectedValue));
    }
  }

  // Executed whenever the time slider is set to a new value.
  public void timeSelected() {
    // Get the selected value of the time slider
    linePos = (int) Math.round(timeSlider.valueProperty().getValue());

    // Update canvas
    updateCanvas();
  }
}
