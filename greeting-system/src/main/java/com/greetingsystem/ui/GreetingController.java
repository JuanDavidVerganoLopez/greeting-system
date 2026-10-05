package com.greetingsystem.ui;

import com.greetingsystem.GreetingService;
import com.greetingsystem.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GreetingController implements NavigableController {
    @FXML
    private Label greetingLabel;

    private SceneNavigator navigator;

    @Override
    public void setNavigator(SceneNavigator navigator) {
        this.navigator = navigator;
    }

    public void setStudent(Student student) {
        greetingLabel.setText(GreetingService.greet(student));
    }

    @FXML
    private void onRequestAnother() {
        navigator.showDetails();
    }

    @FXML
    private void onHome() {
        navigator.showHome();
    }
}
