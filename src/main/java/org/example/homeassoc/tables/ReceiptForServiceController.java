package org.example.homeassoc.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.homeassoc.database.DatabaseConnection;
import org.example.homeassoc.entity.ReceiptForService;
import org.example.homeassoc.entity.Resident;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ReceiptForServiceController {
    @FXML
    private TableColumn<ReceiptForService, Integer> column1;
    @FXML
    private TableColumn<ReceiptForService, Integer> column2;
    @FXML
    private TableColumn<ReceiptForService, Date> column3;
    @FXML
    private TableColumn<ReceiptForService, Integer> column4;
    @FXML
    private TableColumn<ReceiptForService, Integer> column5;
    @FXML
    private TableColumn<ReceiptForService, Integer> column6;

    @FXML
    private TableView<ReceiptForService> receiptForServiceView;

    @FXML
    public void initialize() throws SQLException {
        column1.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Integer>("Receipt_ID"));
        column2.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Integer>("Invoiced_amount"));
        column3.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Date>("date"));
        column4.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Integer>("Counter_Readings_ID_readings"));
        column5.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Integer>("Account_Account_ID"));
        column6.setCellValueFactory(new PropertyValueFactory<ReceiptForService, Integer>("Service_Service_ID"));
        receiptForServiceView.setItems(getAll());
    }

    ObservableList<ReceiptForService> getAll() throws SQLException {
        Connection conn = DatabaseConnection.getInstance();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM \"Receipt for service\"");
        ObservableList<ReceiptForService> persons = FXCollections.observableArrayList();

        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getString(5));
            System.out.println(rs.getString(6));
            persons.add(new ReceiptForService(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
        }
        rs.close();
        st.close();

        return persons;
    }
}
