/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import com.jfoenix.controls.JFXRippler;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class ProfileController implements Initializable {

    @FXML
    private Label fabEdit;
    @FXML
    private AnchorPane fabPane;
    @FXML
    private TableView<Object> _tableStudents;
    @FXML
    private TableColumn<Object, Integer> _id;
    @FXML
    private TableColumn<Object, String> _names;
    @FXML
    private TableColumn<Object, String> _course;

    private Connection connection;
    private ResultSet rs;
    private ObservableList<Object> list_students;
    @FXML
    private AnchorPane holderAnchor;
    @FXML
    private Label lblName;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblLocation;
    @FXML
    private Label lblDepartment;
    @FXML
    private Label lblCourse;
    @FXML
    private Label lblFee;
    @FXML
    private Label lblPaid;
    @FXML
    private Label lblBalance;
    @FXML
    private ToggleGroup filter;
    @FXML
    private Label lblLevel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

    private void setRipples() {
        JFXRippler fXRippler = new JFXRippler(fabEdit);
        fXRippler.setMaskType(JFXRippler.RipplerMask.CIRCLE);
        fXRippler.setRipplerFill(Paint.valueOf("#FF80AF"));
        fabPane.getChildren().add(fXRippler);

    }

    private void buildStudentTable() {


    }

    private void getStudentInfo() {


    }
}
