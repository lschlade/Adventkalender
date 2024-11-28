module at.htl.adventkalender {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htl.adventkalender to javafx.fxml;
    exports at.htl.adventkalender;
}