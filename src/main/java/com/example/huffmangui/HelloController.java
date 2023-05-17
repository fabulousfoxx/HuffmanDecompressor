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
                errorAlert.setContentText("Sth went wrong even though there was input.");
                errorAlert.setHeaderText("error alert");
                errorAlert.showAndWait();
            }

        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Input not valid");
            errorAlert.setContentText("The size of First Name must be between 2 and 25 characters");
            errorAlert.setHeaderText("error alert");
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
                ////TODO MESSAGE BOX
                throw new RuntimeException(e);
            }
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

    /*private void showKey() {
        File key = new File(saveTo.getText());

        try (FileReader fr = new FileReader(key);
             BufferedReader bufferedReader = new BufferedReader(fr)) {
            String intLine = bufferedReader.readLine();
            System.out.println(intLine);

            int inValue = Integer.parseInt(intLine);

            StringBuilder sb = new StringBuilder();
            sb.append("The generated key for the file is: \n");
            for (int i = 0; i < inValue + 1; i++) {
                String line = bufferedReader.readLine();
                sb.append(line).append("\n");
            }

            String messagesText = sb.toString();
            messages.setText(messagesText);

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }*/
}