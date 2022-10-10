package com.oopj.invman;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class MainController {
    @FXML
    private Label amount = new Label();
    @FXML
    private Text item1 = new Text();
    @FXML
    private Text item2 = new Text();
    @FXML
    private Text item3 = new Text();
    @FXML
    private Text item4 = new Text();
    @FXML
    private Text item5 = new Text();
    @FXML
    private Text item6 = new Text();
    @FXML
    private Text item7 = new Text();
    @FXML
    private Text item8 = new Text();
    @FXML
    private Text item9 = new Text();
    @FXML
    private Text item10 = new Text();
    @FXML
    private Text mrp1 = new Text();
    @FXML
    private Text mrp2 = new Text();
    @FXML
    private Text mrp3 = new Text();
    @FXML
    private Text mrp4 = new Text();
    @FXML
    private Text mrp5 = new Text();
    @FXML
    private Text mrp6 = new Text();
    @FXML
    private Text mrp7 = new Text();
    @FXML
    private Text mrp8 = new Text();
    @FXML
    private Text mrp9 = new Text();
    @FXML
    private Text mrp10 = new Text();
    @FXML
    private TextField barcode = new TextField();
    @FXML
    private TextField discount = new TextField();
    static int total=0;
    static int count=0;
    public void launch(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 385, 530);
        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }
    public void initialize(){
        discount.setText("0");
        amount.setVisible(false);
    }
    public void close() {
        Platform.exit();
    }
    public void onExitButtonClicked(){
        close();
    }
    public void addToDb() throws IOException {
        addController add = new addController();
        Stage stage = (Stage) amount.getScene().getWindow();
        stage.hide();
        add.launch();
    }
    public void generateTotal() {
        int i = Integer.parseInt(discount.getText());
        total = total - i;
        amount.setText(String.valueOf(total));
        amount.setVisible(true);
    }
    public void newBill() {
        total = 0;
        count = 0;
        item1.setText("");
        mrp1.setText("");
        item2.setText("");
        mrp2.setText("");
        item3.setText("");
        mrp3.setText("");
        item4.setText("");
        mrp4.setText("");
        item5.setText("");
        mrp5.setText("");
        item6.setText("");
        mrp6.setText("");
        item7.setText("");
        mrp7.setText("");
        item8.setText("");
        mrp8.setText("");
        item9.setText("");
        mrp9.setText("");
        item10.setText("");
        mrp10.setText("");
        amount.setVisible(false);
    }
    public void onItemAdd() throws SQLException {
        count = count + 1;
        if(count>10){
            System.out.println("Bill Full make new");
        }
        database db = new database();
        db.getItem(barcode.getText());
        switch(count){
            case 1:
                item1.setText(database.item);
                mrp1.setText(String.valueOf(database.mrp));
                amount.setVisible(false);
                break;
            case 2:
                item2.setText(database.item);
                mrp2.setText(String.valueOf(database.mrp));
                break;
            case 3:
                item3.setText(database.item);
                mrp3.setText(String.valueOf(database.mrp));
                break;
            case 4:
                item4.setText(database.item);
                mrp4.setText(String.valueOf(database.mrp));
                break;
            case 5:
                item5.setText(database.item);
                mrp5.setText(String.valueOf(database.mrp));
                break;
            case 6:
                item6.setText(database.item);
                mrp6.setText(String.valueOf(database.mrp));
                break;
            case 7:
                item7.setText(database.item);
                mrp7.setText(String.valueOf(database.mrp));
                break;
            case 8:
                item8.setText(database.item);
                mrp8.setText(String.valueOf(database.mrp));
                break;
            case 9:
                item9.setText(database.item);
                mrp9.setText(String.valueOf(database.mrp));
                break;
            case 10:
                item10.setText(database.item);
                mrp10.setText(String.valueOf(database.mrp));
                break;
        }
        total = total + database.mrp;
    }
}
