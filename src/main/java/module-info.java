module com.robayet.inndirector {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.robayet.inndirector to javafx.fxml;
    exports com.robayet.inndirector;

    opens com.robayet.inndirector.Controller to javafx.fxml;
    exports com.robayet.inndirector.Controller;
}