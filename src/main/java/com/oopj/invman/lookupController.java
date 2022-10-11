package com.oopj.invman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class lookupController {
    database db = new database();
    alertBoxController alert = new alertBoxController();
    @FXML
    private TextField barcode;
    @FXML
    private TextField name;
    @FXML
    private TextField mrp;
    @FXML
    Button update = new Button();
    @FXML
    Button delete = new Button();
    @FXML
    Button exit = new Button();
    @FXML
    Button get = new Button();

    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("editItems.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 368, 262);
        Stage stage = new Stage();
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
    public void close() {
        Stage stage = (Stage) mrp.getScene().getWindow();
        stage.hide();
    }
    public void initialize() {
        update.setVisible(false);
        delete.setVisible(false);
    }
    public void update() throws IOException, SQLException {
        String item = name.getText();
        int price = Integer.parseInt(mrp.getText());
        db.updateItem(barcode.getText(), item, price);
        db.getItem(barcode.getText());
        if(database.item.equals(item) && database.mrp==price){
            alertBoxController alert = new alertBoxController();
            exit();
            alert.alert("Successfully Updated");
        }
     }
     public void exit() throws IOException {
        close();
        MainController main = new MainController();
        Stage st = new Stage();
        main.launch(st);
     }
     public void delete() throws SQLException, IOException {
        db.deleteItem(barcode.getText());
        if(!db.getItem(barcode.getText())){
            exit();
            alert.alert("Successfully Deleted");
        }
        db.completeCycle();
     }
     public void get() throws SQLException {
        get.setVisible(false);
        update.setVisible(true);
        delete.setVisible(true);
        db.getItem(barcode.getText());
        name.setText(database.item);
        mrp.setText(String.valueOf(database.mrp));
     }
}
