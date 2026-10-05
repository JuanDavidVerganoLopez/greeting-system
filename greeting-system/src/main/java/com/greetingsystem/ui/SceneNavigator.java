package com.greetingsystem.ui;

import com.greetingsystem.model.Student;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneNavigator {
    private static final String STYLESHEET = "/com/greetingsystem/ui/styles.css";

    private final Stage stage;

    public SceneNavigator(Stage stage) {
        this.stage = stage;
    }

    public void showHome() {
        show("/com/greetingsystem/ui/home.fxml");
    }

    public void showDetails() {
        show("/com/greetingsystem/ui/details.fxml");
    }

    public void showGreeting(Student student) {
        FXMLLoader loader = loader("/com/greetingsystem/ui/greeting.fxml");
        Parent root = load(loader);
        GreetingController controller = loader.getController();
        controller.setStudent(student);
        applyScene(root);
    }

    private void show(String fxmlPath) {
        applyScene(load(loader(fxmlPath)));
    }

    private FXMLLoader loader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(type -> {
            try {
                Object controller = type.getDeclaredConstructor().newInstance();
                if (controller instanceof NavigableController navigable) {
                    navigable.setNavigator(this);
                }
                return controller;
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("Unable to create controller " + type.getName(), e);
            }
        });
        return loader;
    }

    private Parent load(FXMLLoader loader) {
        try {
            return loader.load();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load " + loader.getLocation(), e);
        }
    }

    private void applyScene(Parent root) {
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(root, 520, 400);
            scene.getStylesheets().add(getClass().getResource(STYLESHEET).toExternalForm());
            stage.setScene(scene);
        } else {
            scene.setRoot(root);
        }
    }
}
