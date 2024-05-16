package org.example.homeassoc.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.homeassoc.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateCounter {
    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private TextField field3;

    @FXML
    private Button buttonOk;

    @FXML
    public void clickButtonOk() throws SQLException {
        Connection conn = DatabaseConnection.getInstance();

        Statement st = conn.createStatement();
        st.executeUpdate(String.format("INSERT INTO \"Counter\" VALUES (%s, '%s', %s)",
                field1.getCharacters(),
                field2.getCharacters(),
                field3.getCharacters()
        ));

        st.close();

        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
}
