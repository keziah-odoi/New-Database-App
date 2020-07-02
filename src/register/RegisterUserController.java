/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author kezia
 */
public class RegisterUserController implements Initializable {

    @FXML
    private RadioButton radioFemale;
    @FXML
    private JFXTextField txtLName;
    @FXML
    private ComboBox<String> choiceDesign;
    @FXML
    private JFXTextField txtFName;
    @FXML
    private JFXTextField txtMI;
    @FXML
    private RadioButton radioMale;
    @FXML
    private JFXTextField txtDebit;
    @FXML
    private JFXTextField txtCredit;
    @FXML
    private Button btnSubmit;
    @FXML
    private final ToggleGroup tgGender = new ToggleGroup();
    private Connection connection;
    private PreparedStatement pst;
    

    /**
     * Initializes the controller class.
     */
    ObservableList<String> list = FXCollections.observableArrayList("hq", "west", "ua");
    @FXML
    private ToggleGroup radioGender;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        choiceDesign.setItems(list);
    }    

    @FXML
    private void handleRegistration(ActionEvent event) throws SQLException {
        String lname = txtLName.getText();
        String fname = txtFName.getText();
        String midInit = txtMI.getText();
        String gender; 
        if (radioMale.isSelected())
                gender = "Male";
        else
            gender = "Female";
        String designation = choiceDesign.getValue();
        Double debit = Double.parseDouble(txtDebit.getText());
        Double credit = Double.parseDouble(txtCredit.getText());

        
        if (lname.equals("") || fname.equals("") || midInit.equals("") || designation.equals("") 
                || debit.equals(null) || credit.equals(null)) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
            txtLName.requestFocus();
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/ahmed_db", "root", "");
                pst = connection.prepareStatement("insert into user_register(lname, fname, minitial, gender, designation, debit, credit)values(?,?,?,?,?,?,?)");
                pst.setString(1, lname);
                pst.setString(2, fname);
                pst.setString(3, midInit);
                pst.setString(4, gender);
                pst.setString(5, designation);
                pst.setDouble(6, debit);
                pst.setDouble(7, credit);
                
                int i = pst.executeUpdate();
                System.out.println("Execute Update");
                if (i==1) {
                    System.out.println("Person registered!");
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    
                }

                
            } catch (HeadlessException | ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();           
            }
            finally
            {
                pst.close();
            }
        }
    }
}
