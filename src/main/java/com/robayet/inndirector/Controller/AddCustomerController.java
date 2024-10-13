package com.robayet.inndirector.Controller;

import com.robayet.inndirector.HelloApplication;
import javafx.fxml.FXML;

public class AddCustomerController {
    @FXML
    public void clickLogout(){
        HelloApplication.changeScene("login", 600, 400);
    }
    @FXML
    public void clickRoom(){
        HelloApplication.changeScene("viewRoom",900,600);
    }
    @FXML
    public void clickCheckOut(){
        HelloApplication.changeScene("checkOut",900,600);
    }
}
