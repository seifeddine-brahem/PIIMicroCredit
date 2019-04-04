/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXToolbar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danml
 */
public class DashboardController implements Initializable {

    private Label lblDash;
    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane holderPane;
    @FXML
    private AnchorPane sideAnchor;
    @FXML
    private Label lblMenu;
    @FXML
    private JFXToolbar toolBar;
    @FXML
    private HBox toolBarRight;
    @FXML
    private VBox overflowContainer;

    private AnchorPane nadia, mariem, ahmed,seif,tarek,oumaima;
    @FXML
    private JFXButton btnLogOut;
    @FXML
    private JFXButton btnExit;
    @FXML
    private JFXButton btnClose;
    @FXML
    private JFXButton btnNadia;
    @FXML
    private JFXButton btnMariem;
    @FXML
    private JFXButton btnSeif;
    @FXML
    private JFXButton btnOumaima;
    @FXML
    private JFXButton btnTarek;
    @FXML
    private JFXButton btnAhmed;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JFXRippler fXRippler = new JFXRippler(lblDash);
        JFXRippler fXRippler2 = new JFXRippler(lblMenu);
        fXRippler2.setMaskType((JFXRippler.RipplerMask.RECT));
        sideAnchor.getChildren().add(fXRippler);
        toolBarRight.getChildren().add(fXRippler2);
        openMenus();
        createPages();

    }

    private void openMenus() {
        JFXPopup popup = new JFXPopup();
        popup.setContent(overflowContainer);
        popup.setPopupContainer(stackPane);
        popup.setSource(lblMenu);
        lblMenu.setOnMouseClicked((MouseEvent e) -> {
            popup.show(JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT, -10, 40);
        });

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    //Load all fxml files to a cahce for swapping
    private void createPages() {
        try {
            nadia = FXMLLoader.load(getClass().getResource("/Gui/Overview.fxml"));
            mariem = FXMLLoader.load(getClass().getResource("/Gui/Profile.fxml"));
            ahmed = FXMLLoader.load(getClass().getResource("/Gui/Register.fxml"));
            seif = FXMLLoader.load(getClass().getResource("/Gui/Controls.fxml"));
            oumaima = FXMLLoader.load(getClass().getResource("/Gui/Widgets.fxml"));
            tarek = FXMLLoader.load(getClass().getResource("/Gui/Contacts.fxml"));

            //set up default node on page load
            setNode(nadia);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    @FXML
    private void logOff(ActionEvent event) {

    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void openNadia(ActionEvent event) {
        setNode(nadia);
    }

    @FXML
    private void openMariem(ActionEvent event) {
        setNode(mariem);
    }

    @FXML
    private void openSeif(ActionEvent event) {
        setNode(seif);
    }

    @FXML
    private void openOumaima(ActionEvent event) {
        setNode(oumaima);
    }

    @FXML
    private void openTarek(ActionEvent event) {
        setNode(tarek);
    }

    @FXML
    private void openAhmed(ActionEvent event) {
        setNode(ahmed);
    }

}
