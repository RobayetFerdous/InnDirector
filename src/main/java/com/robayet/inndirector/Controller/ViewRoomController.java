package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class ViewRoomController {
    @FXML
    public void clickLogout(){
        Main.changeScene("login", 600, 400);
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm",900,600);
    }
    @FXML
    public void clickCheckOut(){
        Main.changeScene("checkOut",900,600);
    }
}
