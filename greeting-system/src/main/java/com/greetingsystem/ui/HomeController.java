package com.greetingsystem.ui;

import javafx.fxml.FXML;

public class HomeController implements NavigableController {
    private SceneNavigator navigator;

    @Override
    public void setNavigator(SceneNavigator navigator) {
        this.navigator = navigator;
    }

    @FXML
    private void onRequestGreeting() {
        navigator.showDetails();
    }
}
