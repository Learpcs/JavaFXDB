package org.example.homeassoc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.homeassoc.Main;
import org.example.homeassoc.database.DatabaseConnection;

import java.io.FileNotFoundException;

public class SelectController {

    @FXML
    private Button button1;

    @FXML
    public void ClickButton1() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Account.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button1.getScene().getWindow();
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
    private Button button2;

    @FXML
    public void ClickButton2() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Account Outstanding.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button2.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private Button button3;

    @FXML
    public void ClickButton3() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Apartment.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button3.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private Button button4;

    @FXML
    public void ClickButton4() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Counter.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button4.getScene().getWindow();
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
    private Button button5;

    @FXML
    public void ClickButton5() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Counter Reading.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button5.getScene().getWindow();
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
    private Button button6;

    @FXML
    public void ClickButton6() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("House.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button6.getScene().getWindow();
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
    private Button button7;

    @FXML
    public void ClickButton7() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Journal Apartment Resident.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button7.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private Button button8;

    @FXML
    public void ClickButton8() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Receipt for service.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button8.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private Button button9;

    @FXML
    public void ClickButton9() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Resident.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            System.out.println("wtf1");
            Parent root = loader.load();
            System.out.println("wtf2");
            Stage stage = (Stage) button9.getScene().getWindow();
            System.out.println("wtf3");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (FileNotFoundException e) {
            System.err.println("Failed to load the FXML file.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }


    @FXML
    private Button button10;

    @FXML
    public void ClickButton10() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Service.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) button10.getScene().getWindow();
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
