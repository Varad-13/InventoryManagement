package com.oopj.invman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class addController {
    @FXML
    private TextField barcode;
    @FXML
    private TextField name;
    @FXML
    private TextField mrp;
    database db = new database();
    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("addMore.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 262);
        Stage stage = new Stage();
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
    public void addAndExit() throws IOException, SQLException {
        String bar = barcode.getText();
        String item = name.getText();
        int price = Integer.parseInt(mrp.getText());
        db.insertItem(bar, item, price);
        close();
        MainController main = new MainController();
        Stage stage = new Stage();
        main.launch(stage);
    }
    public void addDontExit() throws SQLException {
        String bar = barcode.getText();
        String item = name.getText();
        int price = Integer.parseInt(mrp.getText());
        db.insertItem(bar, item, price);
        barcode.setText("");
        mrp.setText("");
        name.setText("");
    }
    public void close() {
        Stage stage = (Stage) mrp.getScene().getWindow();
        stage.hide();
    }
}
