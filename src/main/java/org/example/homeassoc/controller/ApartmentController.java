package org.example.homeassoc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.homeassoc.Main;
import org.example.homeassoc.database.DatabaseConnection;
import org.example.homeassoc.entity.Apartment;
import org.example.homeassoc.entity.ReceiptForService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApartmentController {
    @FXML
    private TableColumn<Apartment, Integer> column1;
    @FXML
    private TableColumn<Apartment, Integer> column2;
    @FXML
    private TableColumn<Apartment, Integer> column3;
    @FXML
    private TableColumn<Apartment, Integer> column4;
    @FXML
    private TableColumn<Apartment, Integer> column5;

    @FXML
    private TableView<Apartment> view;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private CheckBox adminBox;

    @FXML
    private Button createButton;

    @FXML
    public void clickCreateButton() throws SQLException {
        System.out.println("TEST");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("CreateApartment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Apartment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        immitate();
        view.setItems(getAll());
    }

    @FXML
    private Button updateButton;

    @FXML
    public void clickUpdateButton() throws SQLException {
        Apartment selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Apartment\" WHERE \"Apartment_ID\" = ?";
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, selectedReceipt.getApartment_ID());
            System.out.println(st);
            st.executeUpdate();

        } else {
            // Optionally, alert the user that no selection was made
            System.out.println("No item selected for deletion.");
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("CreateApartment.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Apartment");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

        view.setItems(getAll());
    }

    @FXML
    private Button deleteButton;

    @FXML
    public void clickDeleteButton() throws SQLException {
        Apartment selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Apartment\" WHERE \"Apartment_ID\" = ?";
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, selectedReceipt.getApartment_number());
            System.out.println(st);
            st.executeUpdate();

        } else {
            // Optionally, alert the user that no selection was made
            System.out.println("No item selected for deletion.");
        }

        view.setItems(getAll());
    }

    @FXML
    private Button deleteAllButton;

    @FXML
    public void clickDeleteAllButton() throws SQLException {
        Apartment selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Apartment\"";
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement st = connection.prepareStatement(sql);
            System.out.println(st);
            st.executeUpdate();

        } else {
            // Optionally, alert the user that no selection was made
            System.out.println("No item selected for deletion.");
        }

        view.setItems(getAll());
    }

    @FXML
    private Button helpButton;

    @FXML
    public void clickHelpButton() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("Help.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Help");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    private Button logoutButton;

    @FXML
    public void clickLogoutButton() {
        DatabaseConnection.setAdmin(false);
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) logoutButton.getScene().getWindow();
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
    private Button leftButton;

    @FXML
    public void clickLeftButton() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Base.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) leftButton.getScene().getWindow();
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
    private Button rightButton;

    @FXML
    public void clickRightButton() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Base.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) rightButton.getScene().getWindow();
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
    private Button selectButton;

    @FXML
    public void clickSelectButton() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Select.fxml"));
            if (loader.getLocation() == null) {
                throw new FileNotFoundException("FXML file not found");
            }
            Parent root = loader.load();
            Stage stage = (Stage) selectButton.getScene().getWindow();
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
    private Button refreshButton;

    @FXML
    public void clickRefreshButton() throws SQLException {
        immitate();
        view.setItems(getAll());
    }

    @FXML
    public void initialize() throws SQLException {
        adminBox.setSelected(DatabaseConnection.getAdmin());
        adminBox.setDisable(true);
        progressBar.setProgress(0);
        createButton.setVisible(DatabaseConnection.getAdmin());
        updateButton.setVisible(DatabaseConnection.getAdmin());
        deleteButton.setVisible(DatabaseConnection.getAdmin());
        deleteAllButton.setVisible(DatabaseConnection.getAdmin());
        column1.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("Apartment_ID"));
        column2.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("Apartment_number"));
        column3.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("Entrance"));
        column4.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("House_House_ID"));
        column5.setCellValueFactory(new PropertyValueFactory<Apartment, Integer>("Number_of_residents"));
        view.setItems(getAll());
    }



    ObservableList<Apartment> getAll() throws SQLException {
        Connection conn = DatabaseConnection.getInstance();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM \"Apartment\"");
        ObservableList<Apartment> persons = FXCollections.observableArrayList();

        while (rs.next()) {
//            System.out.println(rs.getString(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getString(4));
//            System.out.println(rs.getString(5));
//            System.out.println(rs.getString(6));
            persons.add(new Apartment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
        }
        rs.close();
        st.close();

        return persons;
    }

    public void immitate() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    updateProgress(i, 100);
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        if (isCancelled()) {
                            updateProgress(0, 100);
                            break;
                        }
                    }
                }
                return null;
            }
        };

        progressBar.progressProperty().bind(task.progressProperty());

        Thread thread = new Thread(task);
        thread.start();
    }
}
