package com.example.proj1;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventObject;
import java.util.Optional;

import java.util.ResourceBundle;

public class Controller implements Initializable {

    //**********************
    @FXML
    private Button INQ1;

    @FXML
    private Button INQ10;

    @FXML
    private Button INQ11;

    @FXML
    private Button INQ12;

    @FXML
    private Button INQ13;

    @FXML
    private Button INQ14;

    @FXML
    private Button INQ15;

    @FXML
    private Button INQ2;

    @FXML
    private Button INQ3;

    @FXML
    private Button INQ4;

    @FXML
    private Button INQ5;

    @FXML
    private Button INQ6;

    @FXML
    private Button INQ7;

    @FXML
    private Button INQ8;

    @FXML
    private Button INQ9;

    //*************************
    @FXML
    private Button medicalBtn;
    @FXML
    private AnchorPane slotAnchorPane;

    @FXML
    private AnchorPane blueScreen;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label welcomeText;
    @FXML
    private Button closeBtn;
    @FXML
    private Button medicalTestbtn;
    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;

   @FXML
   private AnchorPane YellowScreen;
    @FXML
    private AnchorPane GreenTable_Screen;
    @FXML
    private AnchorPane doctorScreen;
   @FXML
   private Button homeBtn;
    @FXML
    private Button doctorBtn;
    @FXML
    private Button patientBtn;
    @FXML
    private AnchorPane ContentArea;


    private ActionEvent event;

    //**************************************************************  now this is for design fxml code
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
    private Button logout;

//**********************************************************************************
//doctor Screen
@FXML
private Button Doctor_Add_Btn;

    @FXML
    private TextField Doctor_Age;

    @FXML
    private Button Doctor_Delete_Btn;

    @FXML
    private TextField Doctor_Expirence;

    @FXML
    private TextField Doctor_Gender;

    @FXML
    private Button Doctor_ImageImport_Btn;

    @FXML
    private TextField Doctor_Income;

    @FXML
    private TextField Doctor_Name;

    @FXML
    private TextField Doctor_NoT;

    @FXML
    private TextField Doctor_TreatmentChrg;

    @FXML
    private Button Doctor_clear_Btn;

    @FXML
    private TextField Doctor_id;

    @FXML
    private Button Doctor_update_Btn;

    //****************************************this id is for Doctor Data Column*******************
    @FXML
    private TableView<Doctor_Data> addDoctor_tableVew;
    @FXML
    private AnchorPane ImagePane;
    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_Exprience;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_Gender;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_Income;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_Name;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_NoT;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_TreatmentCharges;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_age;

    @FXML
    private TableColumn<Doctor_Data, String> Doctor_col_id;
    //***************************************************************s
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    private Statement statement;

    private Image image;

    //******************************************************************















    public void addDoctorAdd(){
        String Sql = "Insert into doctor( id_doctor,  d_name, d_age, d_gender, d_experience, de_NoT, d_Income, d_treatment_Chrg) " +
                "Values(?,?,?,?,?,?,?)";
        connect = dataBase.connectionDB();

        try{
            Alert alert;
            if(Doctor_id.getText().isEmpty() || Doctor_Name.getText().isEmpty() ||Doctor_Age.getText().isEmpty() ||
                    Doctor_Gender.getText().isEmpty() ||Doctor_Expirence.getText().isEmpty() ||
                    Doctor_NoT.getText().isEmpty() ||Doctor_Income.getText().isEmpty()||Doctor_TreatmentChrg.getText().isEmpty() ){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Meassage");
                alert.setHeaderText(null);
                alert.setContentText("please fill the all blanks field");
                alert.showAndWait();
            } else{

                String checkData = "Select Doctor_id from doctor where iddoctor '"+ Doctor_id.getText() +"'";
                statement  = connect.createStatement();
//               resultSet.statement.executeQuery(checkData);
                result.getStatement().executeQuery(checkData);
                if(result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Meassage");
                    alert.setHeaderText(null);
                    alert.setContentText("Doctor id"+  Doctor_id.getText() + "was already exists");
                    alert.showAndWait();
                }else{
                }
                prepare = connect.prepareStatement(Sql);
                prepare.setString(1,Doctor_id.getText());
                prepare.setString(2,Doctor_Name.getText());
                prepare.setString(3,Doctor_Age.getText());
                prepare.setString(4,Doctor_Gender.getText());
                prepare.setString(5,Doctor_Expirence.getText());
                prepare.setString(6,Doctor_NoT.getText());
                prepare.setString(7,Doctor_Income.getText());
                prepare.setString(8,Doctor_TreatmentChrg.getText());
                prepare.execute(Sql);
                prepare.executeUpdate();
                addDoctorShowList();

            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }

   /* public void AddDoctorImage(){
        FileChooser open = new FileChooser();
        open.setTitle("Import Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File ", "*jpg","*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());
        if(file!=null){
            image = new Image( file.toURI().toString(),307,270,false,true);
           // ImagePane.setImage(image);
            getData.path = file.getAbsolutePath();
        }
    }*/





    //*******************************************************************************
// this is for add data in the list

    public ObservableList<Doctor_Data > addDoctorListData() {
        String sql = "select * from doctor";

        ObservableList<Doctor_Data> listData = FXCollections.observableArrayList();
        connect = dataBase.connectionDB();

        try{
             prepare = connect.prepareStatement(sql);
             result = prepare.executeQuery();

             Doctor_Data Dr_Data;
             while(result.next()){
                Dr_Data = new Doctor_Data(result.getInt("iddoctor")
                        // green text name is must be same as database table name
                        ,result.getString("D_Name"), result.getInt("D_Age")
                        ,result.getString("D_Gender"),result.getInt("D_Expirence")
                        ,result.getInt("D_NoT"),result.getInt("D_Income")
                        ,result.getString("D_Image")
                        ,result.getInt("D_Treament_chrg"));

                 listData.add(Dr_Data);
             }

        }catch(Exception e ){
        e.printStackTrace();
        }
        return listData;

    }
    //*******************************************************
    private ObservableList<Doctor_Data> addDoctorList;
     public void addDoctorShowList(){
        addDoctorList = addDoctorListData();
        Doctor_col_id.setCellValueFactory(new PropertyValueFactory<>("D_id"));
        Doctor_col_Name.setCellValueFactory(new PropertyValueFactory<>("D_Name"));
        Doctor_col_age.setCellValueFactory(new PropertyValueFactory<>("D_Age"));
        Doctor_col_Gender.setCellValueFactory(new PropertyValueFactory<>("D_Gender"));
        Doctor_col_Exprience.setCellValueFactory(new PropertyValueFactory<>("D_Experience"));
        Doctor_col_NoT.setCellValueFactory(new PropertyValueFactory<>("D_NoT"));
        Doctor_col_Income.setCellValueFactory(new PropertyValueFactory<>("D_Income"));
        Doctor_col_TreatmentCharges.setCellValueFactory(new PropertyValueFactory<>("D_Treatment_Chrg"));

        addDoctor_tableVew.setItems(addDoctorList);
    }

    public void addDoctorSelect(){
        Doctor_Data Dr_data = addDoctor_tableVew.getSelectionModel().getSelectedItem();
        int num = addDoctor_tableVew.getSelectionModel().getSelectedIndex();

        if((num = -1) < - 1){
            return;
        }
        Doctor_id.setText(String.valueOf(Dr_data.getD_id()));
        Doctor_Name.setText(String.valueOf(Dr_data.getD_Name()));
        Doctor_Age.setText(String.valueOf(Dr_data.getD_Age()));
        Doctor_Gender.setText(String.valueOf(Dr_data.getD_Gender()));
        Doctor_Expirence.setText(String.valueOf(Dr_data.getD_Experience()));
        Doctor_NoT.setText(String.valueOf(Dr_data.getD_NoT()));

       /* Doctor_Income.setText(String.valueOf(Dr_data.getD_Income()));
        String uri = "file:" + Dr_data.getD_Image();
        image =new Image(uri,307,207,false,true);
        ImagePane.setImage(image);
        getData.path= Dr_data.getD_Image();*/

    }



















    //********************************************* SWITCHING THE PANE ******************************************

//    public void switchToScene1(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
    public void go_to_inquery(ActionEvent event){
        if(event.getSource()==INQ1){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ2){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ3){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ4){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ5){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ6){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ7){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ8){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ9){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ10){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ11){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ12){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ13){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ14){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==INQ15){
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
        }


    }

// switch one anchor pane to another pane
    public void switchform(ActionEvent event){
        if(event.getSource()==homeBtn){
            YellowScreen.setVisible(true);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(false);
            slotAnchorPane.setVisible(false);
        }
        else if(event.getSource()==doctorBtn){
            doctorScreen.setVisible(true);
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            blueScreen.setVisible(false);
            slotAnchorPane.setVisible(false);

           addDoctorShowList();
        }
        else if(event.getSource()==patientBtn){
            GreenTable_Screen.setVisible(true);
            YellowScreen.setVisible(false);
            doctorScreen.setVisible(false);
            blueScreen.setVisible(false);
            slotAnchorPane.setVisible(false);
        }
        else if (event.getSource()==SlotBookBtn){
            slotAnchorPane.setVisible(true);
            blueScreen.setVisible(false);
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
        }

        else if (event.getSource()==medicalBtn){
            blueScreen.setVisible(true);
            slotAnchorPane.setVisible(false);
            YellowScreen.setVisible(false);
            GreenTable_Screen.setVisible(false);
            doctorScreen.setVisible(false);
        }

    }
    //**********************************LOGOUT BUTTON***************************************
    public void logout(){
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you Sure you want to LogOut your Account...!");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                logout.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // this is for last pasgw to send the request
    public void sendRequest(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you Sure to send the request..!");
        Optional<ButtonType> option = alert.showAndWait();


    }


    //******************************** LOGIN *******************************

    public void loginAdmin() {
        String sql = "Select * from user where Email =? and password =? ";
        connect = dataBase.connectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            result = prepare.executeQuery();

            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("GLTI AA REHE HAI BHAI");
                alert.setHeaderText("Bhai tune kuch to glt likha hai check kr le ek bar");
                /*alert.setContentText("Bhai tune kuch to glt likha hai check kr le ek barr");*/
                alert.showAndWait();
                System.out.println("Both the fields is blank...");
            } else {
                if (result.next()) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("INFORMATION MESSAGE");
                    /*  alert.setHeaderText("null");*/
                    alert.setContentText("Arre whaa bhai tera Email id or password dono shai hai ");
                    alert.showAndWait();
                    //  --> hide your login form
                    loginBtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("GLTI AA REHE HAI BHAI");
                    /* alert.setHeaderText("null");*/
                    alert.setContentText("Bhai  ya to Email glt hai ya to password glt hai ");
                    alert.showAndWait();
                    System.out.println("Something is Error either id was wrong or password....");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeBtn() {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addDoctorShowList();

    }
}
