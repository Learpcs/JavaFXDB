package org.example.homeassoc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import org.example.homeassoc.Main;
import org.example.homeassoc.database.DatabaseConnection;
import org.example.homeassoc.entity.ReceiptForService;


import java.io.FileNotFoundException;


public class LoginController {
    @FXML
    private Button userButton;


    @FXML
    public void clickUserButton(javafx.event.ActionEvent event) {
        DatabaseConnection.setAdmin(false);
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Select.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private Button adminButton;
    public void clickAdminButton(javafx.event.ActionEvent event) {
        DatabaseConnection.setAdmin(true);
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Select.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
