module lk.aulakapora.vehiculohub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires javafx.base;


    opens lk.aulakapora.vehiculohub to javafx.fxml;
    exports lk.aulakapora.vehiculohub;

    exports lk.aulakapora.vehiculohub.controller;
    opens lk.aulakapora.vehiculohub.controller to javafx.fxml;

    // Open package to specific module
    opens lk.aulakapora.vehiculohub.tm to javafx.base;

    // Export package
    exports lk.aulakapora.vehiculohub.tm;
}