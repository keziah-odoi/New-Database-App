package home;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HomeUIController {

    @FXML
    private Button btnImportXls;

    @FXML
    private Button btnExportXls;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnViewDB;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnDeposit;

    @FXML
    private ImageView imgDeposit;

    @FXML
    private Button btnWithdrar;

    @FXML
    private ImageView imgWithdraw;

    @FXML
    private Button btnApplyLoan;

    @FXML
    private ImageView imgApplyLoan;

    @FXML
    private Button btnCheckBal;

    @FXML
    private ImageView imgCheckBal;
    
    private  Connection connection;
    private PreparedStatement preparedStatement;
 
    @FXML
    void handleApplyLoan(MouseEvent event) {

    }

    @FXML
    void handleCheckBal(MouseEvent event) {

    }

    @FXML
    void handleDeposit(MouseEvent event) {

    }

    @FXML
    void handleEdit(ActionEvent event) {

    }

    @FXML
    void handleExportXls(ActionEvent event) {
        

    }

    @FXML
    void handleImportXls(ActionEvent event) {
//       FileChooser fc = new FileChooser();
//       fc.setTitle("Select File");
//       File file = fc.showOpenDialog(null);
//       FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel Files", "*.xls");
//       FileChooser.ExtensionFilter extFilter1 = new FileChooser.ExtensionFilter("Excel Files", "*.xlsx");
//       fc.getExtensionFilters().add(extFilter);
//       fc.getExtensionFilters().add(extFilter1);      
//       if (file != null) {
//       System.out.print("File selected");
//       
           try {
               Class.forName("com.sql.jcbc.Driver");
               connection = DriverManager.getConnection("jdbc:mysql://localhost/ahmed_db", "root", "");
               preparedStatement = connection.prepareStatement("insert into user_register(lname, fname, minitial, gender, designation, debit, credit)values(?,?,?,?,?,?,?)");

               FileInputStream fileInputStream = new FileInputStream(new File("trial.xlsx"));
               XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
               XSSFSheet sheet = workbook.getSheetAt(0);
               Row row;
               for (int i=1; i<sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                preparedStatement.setString(1, row.getCell(0).getStringCellValue());
                preparedStatement.setString(2, row.getCell(1).getStringCellValue());
                preparedStatement.setString(3, row.getCell(2).getStringCellValue());
                preparedStatement.setString(4, row.getCell(3).getStringCellValue());
                preparedStatement.setString(5, row.getCell(4).getStringCellValue());
                preparedStatement.setDouble(6, row.getCell(5).getNumericCellValue());
                preparedStatement.setDouble(7, row.getCell(6).getNumericCellValue());
                preparedStatement.execute();

               }
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information DIalogue");
               alert.setHeaderText(null);
               alert.setContentText("User Details Imported Successfully!");
               alert.showAndWait();
                
               workbook.close();
               fileInputStream.close();
               preparedStatement.close();
           } 
           catch (Exception e) {
           }
       
       }
       //if file extension isnt that of an excel sheet print an error message
//       else  {
//        JOptionPane.showMessageDialog(null, "Invalid File Format!");
//    
//       }
//       
     
    

    @FXML
    void handleRegister(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/register/RegisterUser.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Register User");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/save-money.png")));
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(HomeUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

    @FXML
    void handleViewDB(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewDB/ViewDB.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("View Database");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/save-money.png")));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
       e.printStackTrace();
        }
      

    }

    @FXML
    void handleWithdraw(MouseEvent event) {

    }

}
