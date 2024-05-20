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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.homeassoc.Main;
import org.example.homeassoc.database.DatabaseConnection;
import org.example.homeassoc.entity.AccountOutstanding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountOutstandingViewController {
    @FXML
    private TableColumn<AccountOutstanding, Integer> column1;
    @FXML
    private TableColumn<AccountOutstanding, Integer> column2;
    @FXML
    private TableColumn<AccountOutstanding, Date> column3;
    @FXML
    private TableColumn<AccountOutstanding, Integer> column4;

    @FXML
    private TableView<AccountOutstanding> view;

    @FXML
    private CheckBox adminBox;

    @FXML
    private Button createButton;

    @FXML
    private DatePicker from, to;

    @FXML
    public void clickCreateButton() throws SQLException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("CreateAccountOutstanding.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Account Outstanding");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
        view.setItems(getAll());
    }

    @FXML
    private Button updateButton;

    @FXML
    public void clickUpdateButton() throws SQLException {
        AccountOutstanding selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Account Outstanding\" WHERE \"Record_ID\" = ?";
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, selectedReceipt.getRecord_ID());
            System.out.println(st);
            st.executeUpdate();

        } else {
            // Optionally, alert the user that no selection was made
            System.out.println("No item selected for deletion.");
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("CreateAccountOutstanding.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Account Outstanding");
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
        AccountOutstanding selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Account Outstanding\" WHERE \"Record_ID\" = ?";
            Connection connection = DatabaseConnection.getInstance();

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, selectedReceipt.getRecord_ID());
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
    private Text debt;

    @FXML
    public void clickDeleteAllButton() throws SQLException {
        AccountOutstanding selectedReceipt = view.getSelectionModel().getSelectedItem();

        if (selectedReceipt != null) {
            String sql = "DELETE FROM public.\"Account Outstanding\"";
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
        debt.setText("None");
        view.setItems(getAll());
    }

    @FXML
    public void initialize() throws SQLException {
        view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                String valueFromColumn2 = String.valueOf(newSelection.getAccount_Account_ID());

                Connection conn = null;
                try {
                    conn = DatabaseConnection.getInstance();

                    String startDate;
                    String endDate;

                    if (from.getValue() == null) {
                        startDate ="1970-01-01";
                    }
                    else {
                        startDate = from.getValue().toString();
                    }

                    if (to.getValue() == null) {
                        endDate ="2070-01-01";
                    }
                    else {
                        endDate = to.getValue().toString();
                    }

                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Account Outstanding\" WHERE \"Account_Account_ID\" = %s AND \"Maturity_date\" BETWEEN '%s' AND '%s'", valueFromColumn2, startDate, endDate));
                    ObservableList<AccountOutstanding> persons = FXCollections.observableArrayList();

                    while (rs.next()) {
                        persons.add(new AccountOutstanding(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4)));
                    }
                    rs.close();
                    st.close();
                    view.getSelectionModel().clearSelection();
                    view.setItems(persons);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                debt.setText(valueFromColumn2);
            }
        });
        adminBox.setSelected(DatabaseConnection.getAdmin());
        adminBox.setDisable(true);
        createButton.setVisible(DatabaseConnection.getAdmin());
        updateButton.setVisible(DatabaseConnection.getAdmin());
        deleteButton.setVisible(DatabaseConnection.getAdmin());
        deleteAllButton.setVisible(DatabaseConnection.getAdmin());
        column1.setCellValueFactory(new PropertyValueFactory<AccountOutstanding, Integer>("Record_ID"));
        column2.setCellValueFactory(new PropertyValueFactory<AccountOutstanding, Integer>("Account_Account_ID"));
        column3.setCellValueFactory(new PropertyValueFactory<AccountOutstanding, Date>("Maturity_date"));
        column4.setCellValueFactory(new PropertyValueFactory<AccountOutstanding, Integer>("Sum"));
        view.setItems(getAll());
    }



    ObservableList<AccountOutstanding> getAll() throws SQLException {
        Connection conn = DatabaseConnection.getInstance();

        String startDate;
        String endDate;

        if (from.getValue() == null) {
            startDate ="1970-01-01";
        }
        else {
            startDate = from.getValue().toString();
        }

        if (to.getValue() == null) {
            endDate ="2070-01-01";
        }
        else {
            endDate = to.getValue().toString();
        }

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(String.format("SELECT * FROM \"Account Outstanding\" WHERE \"Maturity_date\" BETWEEN '%s' AND '%s'", startDate, endDate));
        ObservableList<AccountOutstanding> persons = FXCollections.observableArrayList();

        while (rs.next()) {
            persons.add(new AccountOutstanding(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4)));
        }
        rs.close();
        st.close();
        view.getSelectionModel().clearSelection();
        view.setItems(persons);

        return persons;
    }


}
