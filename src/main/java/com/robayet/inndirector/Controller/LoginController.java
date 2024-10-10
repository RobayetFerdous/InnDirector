package com.robayet.inndirector.Controller;

import com.robayet.inndirector.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    ChoiceBox<String> userTypeLogin;
    @FXML
    TextField userNameLogin;
    @FXML
    PasswordField passwordLogin;

    String[] userTypeInLogin = {"Admin", "Receptionist"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userTypeLogin.getItems().addAll(userTypeInLogin);
    }

    @FXML
    public void clickLogin() {
        String userType = userTypeLogin.getValue();
        String userName = userNameLogin.getText();
        String password = passwordLogin.getText();
        System.out.println(userType + " " + userName + " " + password);

        System.out.println("Login Successfull!");

        HelloApplication.changeScene("receptionistPanel",900,600);
    }

    @FXML
    public void clickSignup(){
        HelloApplication.changeScene("signup",600,400);
    }
}
