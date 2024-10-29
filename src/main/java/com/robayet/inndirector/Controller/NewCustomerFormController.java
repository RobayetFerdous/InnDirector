package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class NewCustomerFormController {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickRoom(){
        Main.changeScene("viewRoom");
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm");
    }
}
