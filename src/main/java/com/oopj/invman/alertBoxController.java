package com.oopj.invman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class alertBoxController {
    @FXML
    private javafx.scene.control.Button Exit;
    @FXML
    private javafx.scene.text.Text text = new Text();
    static String a;
    static String b;
    @FXML
    public void launch() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("alertBox.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 360,120);
        Stage stage = new Stage();
        stage.setTitle(b);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onExitButtonClicked() {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.hide();
    }
    public void alert(String x) throws IOException {
        alertBoxController.a = x;
        alertBoxController.b = "Information";
        launch();
    }
    public void setText() {
        text.setText(a);
    }
    public void initialize(){
        setText();
    }
}

