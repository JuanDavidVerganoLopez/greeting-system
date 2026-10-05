package com.greetingsystem.ui;

import com.greetingsystem.model.Student;
import com.greetingsystem.model.TimeOfDay;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DetailsController implements NavigableController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private ToggleGroup timeOfDayGroup;
    @FXML
    private RadioButton amRadio;
    @FXML
    private RadioButton pmRadio;
    @FXML
    private Label errorLabel;

    private SceneNavigator navigator;

    @Override
    public void setNavigator(SceneNavigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    private void initialize() {
        amRadio.setUserData(TimeOfDay.AM);
        pmRadio.setUserData(TimeOfDay.PM);
    }

    @FXML
    private void onSubmit() {
        try {
            String name = nameField.getText();
            int age = parseAge(ageField.getText());
            TimeOfDay timeOfDay = selectedTimeOfDay();
            navigator.showGreeting(new Student(name, age, timeOfDay));
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    @FXML
    private void onBack() {
        navigator.showHome();
    }

    private int parseAge(String rawAge) {
        if (rawAge == null || rawAge.isBlank()) {
            throw new IllegalArgumentException("Age is required.");
        }
        try {
            return Integer.parseInt(rawAge.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a whole number.");
        }
    }

    private TimeOfDay selectedTimeOfDay() {
        if (timeOfDayGroup.getSelectedToggle() == null) {
            throw new IllegalArgumentException("Please choose AM or PM.");
        }
        return (TimeOfDay) timeOfDayGroup.getSelectedToggle().getUserData();
    }
}
