package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class ReceptionistPanelController {
    @FXML
    public void clickLogout() {
        Main.changeScene("login");
    }

    @FXML
    public void clickNewCustomer() {
        Main.changeScene("newCustomerForm");
    }

    @FXML
    public void clickRoom() {
        Main.changeScene("viewRoom");
    }

    @FXML
    public void clickCheckOut() {
        Main.changeScene("checkOut");
    }
    @FXML
    public void clickCustomerInfo(){
        Main.changeScene("customerInfo");
    }
    @FXML
    public void clickUpdateRoom(){
        Main.changeScene("updateRoom");
    }
    @FXML
    void clickPickUpService() {
        Main.changeScene("pickUpService");
    }
}
