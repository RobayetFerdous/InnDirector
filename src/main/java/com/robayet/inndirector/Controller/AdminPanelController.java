package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminPanelController {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickNewRoom(){
        Main.changeScene("addRoom");
    }
    @FXML
    void clickViewRoom() {
        Main.changeScene("viewRoomAsAdmin");
    }
}
