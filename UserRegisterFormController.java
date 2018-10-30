package leavemanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class UserRegisterFormController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label lbl_userreg;
    @FXML
    private Label lbl_fname;
    @FXML
    private Label lbl_lname;
    @FXML
    private Label lbl_email;
    @FXML
    private Label lbl_role;
    @FXML
    private Label lbl_department;
    @FXML
    private Label lbl_username;
    @FXML
    private Label lbl_password;
    @FXML
    private TextField tf_fname;
    @FXML
    private TextField tf_lname;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_uname;
    @FXML
    private ComboBox<String> combo_role;
    @FXML
    private ComboBox<String> combo_department;
    @FXML
    private PasswordField pwf_password;
    @FXML
    private Button btn_save;

    private DBConnector db;
    private Connection conn = null;
    private PreparedStatement pst = null;
    ResultSet rs = null;
    ObservableList<String> list1 = FXCollections.observableArrayList("Dean", "HOD", "Lecturer", "Demo", "Non-Acadamic");
    ObservableList<String> list2 = FXCollections.observableArrayList("CIS", "PST", "NR", "FST", "SST");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combo_role.setItems(list1);
        combo_department.setItems(list2);
        db = new DBConnector();
    }

    @FXML
    public void btnSave(ActionEvent event) throws SQLException {
        Connection conn = db.Connect();
        String firstname = tf_fname.getText();
        String lastname = tf_lname.getText();
        String email = tf_email.getText();
        String role = combo_role.getValue();
        String department = combo_department.getValue();
        String username = tf_uname.getText();
        String password = pwf_password.getText();

        try {

            String sql = "insert into userregister (firstname,lastname,email,role,department,username,password) values "
                    + "(?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, firstname);
            pst.setString(2, lastname);
            pst.setString(3, email);
            pst.setString(4, role);
            pst.setString(5, department);
            pst.setString(6, username);
            pst.setString(7, password);
            JOptionPane.showMessageDialog(null, "Data inserted");
        } catch (Exception ex) {
            Logger.getLogger(UserRegisterFormController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            pst.execute();
            pst.close();
        }
        tf_fname.clear();
        tf_lname.clear();
        tf_email.clear();
        combo_role.setValue(null);
        combo_department.setValue(null);
        tf_uname.clear();
        pwf_password.clear();

    }

}
