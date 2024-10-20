package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class CheckOutController {
    @FXML
    public void clickLogout(){
        Main.changeScene("login", 600, 400);
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm",900,600);
    }
    @FXML
    public void clickRoom(){
        Main.changeScene("viewRoom",900,600);
    }
}
