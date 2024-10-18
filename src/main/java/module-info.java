module lk.aulakapora.vehiculohub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens lk.aulakapora.vehiculohub to javafx.fxml;
    exports lk.aulakapora.vehiculohub;

    exports lk.aulakapora.vehiculohub.controller;
    opens lk.aulakapora.vehiculohub.controller to javafx.fxml;
}