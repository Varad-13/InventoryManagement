module com.oopj.invman {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.oopj.invman to javafx.fxml;
    exports com.oopj.invman;
}