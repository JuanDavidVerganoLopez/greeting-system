package com.greetingsystem;

import com.greetingsystem.ui.SceneNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class GreetingApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Greeting System");
        stage.setMinWidth(480);
        stage.setMinHeight(360);
        new SceneNavigator(stage).showHome();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
