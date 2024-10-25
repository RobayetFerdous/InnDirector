package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
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
    public void clickSignup(){

        String userName = userNameSignup.getText();
        String password = passwordSignup.getText();


        String line = userName + "," + password + "\n";

        try{
            RandomAccessFile raf = new RandomAccessFile("signup.txt","rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Main.changeScene("login",600,400);
    }
}
