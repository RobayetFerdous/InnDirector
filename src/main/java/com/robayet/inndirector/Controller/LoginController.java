package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    TextField userNameLogin;
    @FXML
    PasswordField passwordLogin;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void clickLogin() {

        System.out.println("Login Successfull!");

        Main.changeScene("receptionistPanel",900,600);
    }

    @FXML
    public void clickSignup(){
        Main.changeScene("signup",600,400);
    }
}
