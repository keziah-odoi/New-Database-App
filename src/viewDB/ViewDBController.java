/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDB;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class ViewDBController implements Initializable {
    
    @FXML
    private TableView<PersonInfo> tablePersons;

    @FXML
    private TableColumn<PersonInfo, String> colLastName;

    @FXML
    private TableColumn<PersonInfo, String> colFirstName;

    @FXML
    private TableColumn<PersonInfo, String> colMI;

    @FXML
    private TableColumn<PersonInfo, String> colGender;

    @FXML
    private TableColumn<PersonInfo, String> colDesignation;
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;

    ObservableList<PersonInfo> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/ahmed_db", "root", "");
            
            rs = connection.createStatement().executeQuery("select * from user_register");
            
            while(rs.next()) {
                oblist.add(new PersonInfo(rs.getString("lname"), rs.getString("fname"), rs.getString("minitial"), rs.getString("gender"), rs.getString("designation")));
            }

            
        } 
        catch (Exception ex) {
             ex.printStackTrace();        } 
        
        colLastName.setCellFactory(new PropertyValueFactory<>("lname"));
        colFirstName.setCellFactory(new PropertyValueFactory<>("fname"));
        colMI.setCellFactory(new PropertyValueFactory<>("minitial"));
        colGender.setCellFactory(new PropertyValueFactory<>("gender"));
        colDesignation.setCellFactory(new PropertyValueFactory<>("designation"));
        
       
        tablePersons.setItems(oblist);
    }   
    
}
