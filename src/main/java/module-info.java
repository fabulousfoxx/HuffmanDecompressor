module com.example.huffmangui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.huffmangui to javafx.fxml;
    exports com.example.huffmangui;
}