package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class CheckOutController {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm");
    }
    @FXML
    public void clickRoom(){
        Main.changeScene("viewRoom");
    }
    @FXML
    public void clickCustomerInfo(){
        Main.changeScene("customerInfo");
    }
}
