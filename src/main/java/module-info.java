module com.robayet.inndirector {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.robayet.inndirector to javafx.fxml;
    exports com.robayet.inndirector;

    opens com.robayet.inndirector.Controller to javafx.fxml;
    exports com.robayet.inndirector.Controller;

    opens com.robayet.inndirector.model to javafx.fxml;
    exports com.robayet.inndirector.model;

    opens com.robayet.inndirector.service to javafx.fxml;
    exports com.robayet.inndirector.service;
}