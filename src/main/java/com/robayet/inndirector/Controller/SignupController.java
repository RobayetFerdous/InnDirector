package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.UserInfo;
import com.robayet.inndirector.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController {


    @FXML
    TextField userNameSignup;
    @FXML
    PasswordField passwordSignup;

    @FXML
    public void clickSignup(ActionEvent event) {
        String role = "normal";
        UserService userService = new UserService();
        userService.signup(new UserInfo(role, userNameSignup.getText(), passwordSignup.getText()));

        System.out.println("Sign-up Successfull!");

        Main.changeScene("login", 600, 400);
    }
}
