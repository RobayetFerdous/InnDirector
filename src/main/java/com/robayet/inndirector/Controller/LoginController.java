package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.UserInfo;
import com.robayet.inndirector.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    public void clickLogin(ActionEvent event) {
        String username = userNameLogin.getText();
        String password = passwordLogin.getText();

        UserService userService = new UserService();
        boolean login = false;

        for (UserInfo user : userService.list()){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                login =true;
                System.out.println("Login successfull!");
                if ("normal".equals(user.getRole())){
                    Main.changeScene("receptionistPanel");
                } else if ("admin".equals(user.getRole())) {
                    Main.changeScene("adminPanel");
                }
                break;
            }
        }if (!login){
            if (username.isBlank() || password.isBlank()){
                System.out.println("Blank username or password");
                //alertbox
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Username or assword can't be blank");
                alert.showAndWait();
            }
            else {
                System.out.println("Invalid username or password");
                //alertbox
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Please check your username and password and try again.");
                alert.showAndWait();

                //clr pass
                passwordLogin.clear();
            }
        }
    }

    @FXML
    public void clickSignup(){
        Main.changeScene("signup");
    }
}
