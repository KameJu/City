module com.example.city {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.city to javafx.fxml;
    exports com.example.city;
}