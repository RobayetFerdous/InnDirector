package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import javafx.fxml.FXML;

public class AddEmployeeController {
    @FXML
    public void clickLogout() {
        Main.changeScene("login");
    }
}
