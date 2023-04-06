package com.example.proj1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoard_Controller implements Initializable {


    @FXML
    private AnchorPane ContentArea;

    @FXML
    private AnchorPane GreenTable_Screen;

    @FXML
    private TableColumn<?, ?> P_Address_Col;

    @FXML
    private TableColumn<?, ?> P_Age_Col;

    @FXML
    private TableColumn<?, ?> P_Amount_Col;

    @FXML
    private TableColumn<?, ?> P_CheckUp_Col;

    @FXML
    private TableColumn<?, ?> P_DR_Refer_Col;

    @FXML
    private TableColumn<?, ?> P_Gender_Col;

    @FXML
    private TableColumn<?, ?> P_Name_Col;

    @FXML
    private TableColumn<?, ?> P_PhoneNo_Col;

    @FXML
    private TableColumn<?, ?> P_SNo_Col;

    @FXML
    private Button SlotBookBtn;

    @FXML
    private AnchorPane YellowScreen;

    @FXML
    private Button doctorBtn;

    @FXML
    private AnchorPane doctorScreen;

    @FXML
    private Button homeBtn;

    @FXML
    private Button patientBtn;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }
}
