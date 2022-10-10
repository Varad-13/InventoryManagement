package com.oopj.invman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Driver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainController main = new MainController();
        main.launch(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}