package com.example.huffmangui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField input_file_name1;
    @FXML
    private TextField save_dictionary_to1;
    @FXML
    private TextField save_coded_message1;

    @FXML
    private TextField input_file_name2;

    @FXML
    private TextField save_encoded_message2;

    @FXML
    private TextArea dictionary_field;



    @FXML
    protected void onCompressButtonClick() {
        if(!input_file_name1.getText().isBlank()){
            Facade fasada =new Facade();
            try {
                fasada.compress(input_file_name1.getText());
                showDictionary();
                //fasada.compress(input_file_name1.getText());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Fatal error");
                errorAlert.setContentText("Something went wrong even though there was input.");
                errorAlert.setHeaderText("Error alert");
                errorAlert.showAndWait();
            }

        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Input not valid");
            errorAlert.setContentText("You must enter name of the file placed in the 'files' catalogue");
            errorAlert.setHeaderText("Error alert");
            errorAlert.showAndWait();
        }
    }

    @FXML
    protected void onDecompressButtonClick() {
        if(!input_file_name2.getText().isBlank() && !save_encoded_message2.getText().isBlank()){
            Facade fasada =new Facade();
            try {
                fasada.decompress(input_file_name2.getText(), save_encoded_message2.getText());
                showDictionary();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Fatal error");
                errorAlert.setContentText("Something went wrong even though there was input.");
                errorAlert.setHeaderText("Error alert");
                errorAlert.showAndWait();
            }
        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Input not valid");
            errorAlert.setContentText("You must enter name of the file placed in the 'files' catalogue");
            errorAlert.setHeaderText("Error alert");
            errorAlert.showAndWait();
        }
    }

    private void showDictionary(){
        dictionary_field.setText("");
        //File dictionary = new File("files/_dictionary.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader("files/_dictionary.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary_field.appendText(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}