/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leavemgt;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Kasuni Gaveshika
 */
public class FXMLDocumentController implements Initializable {
    
 @FXML
    private Button button;

    @FXML
    private Label role_btn;

    @FXML
    private ComboBox<String> department_combox;

    @FXML
    private Label password_btn;

    @FXML
    private Label username_btn;

    @FXML
    private Label label;

    @FXML
    private Label department_btn;

    @FXML
    private TextField username_txt;

    @FXML
    private TextField password_txt;

    @FXML
    private ComboBox<String> role_cmbox;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @FXML
    void comboaction(ActionEvent event) {
//label.setText(department_combox.getValue());
    }
ObservableList<String> list = FXCollections.observableArrayList("CIS","PST","NR","FST","SST");

ObservableList<String> rolelist = FXCollections.observableArrayList("HOD","DEAN","LECTURER","DEMO","NON ACADEMIC STAFF");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet.");
        department_combox.setItems(list);
        role_cmbox.setItems(rolelist);
    }
}
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//    }    
    

