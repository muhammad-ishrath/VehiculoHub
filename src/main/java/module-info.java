module lk.aulakapora.vehiculohub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.aulakapora.vehiculohub to javafx.fxml;
    exports lk.aulakapora.vehiculohub;
}