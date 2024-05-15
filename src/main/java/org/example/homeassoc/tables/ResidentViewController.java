package org.example.homeassoc.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.homeassoc.database.DatabaseConnection;
import org.example.homeassoc.entity.Resident;

import java.sql.*;

public class ResidentViewController {

    @FXML
    private TableColumn<Resident, Integer> idColumn;

    @FXML
    private TableColumn<Resident, String> emailColumn;

    @FXML
    private TableColumn<Resident, String> nameColumn;

    @FXML
    private TableView<Resident> personView;

    @FXML
    public void initialize() throws SQLException {
        idColumn.setCellValueFactory(new PropertyValueFactory<Resident, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Resident, String>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Resident, String>("apparts"));
        personView.setItems(getAllPeople());
    }

    ObservableList<Resident> getAllPeople() throws SQLException {
        Connection conn = DatabaseConnection.getInstance();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM \"Receipt for service\"");
        ObservableList<Resident> persons = FXCollections.observableArrayList();

        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));

            persons.add(new Resident(rs.getInt(1), rs.getString(2), rs.getInt(3)));

        }
        rs.close();
        st.close();

        persons.add(new Resident(1, "you", 1));
        persons.add(new Resident(2, "me", 2));
        return persons;
    }

}
