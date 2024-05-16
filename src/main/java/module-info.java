module org.example.homeassoc {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires com.fasterxml.jackson.databind;
    requires java.sql;
    requires java.desktop;

    opens org.example.homeassoc to javafx.fxml;
    exports org.example.homeassoc;
    exports org.example.homeassoc.entity;
    opens org.example.homeassoc.entity to javafx.fxml;
    exports org.example.homeassoc.controller;
    opens org.example.homeassoc.controller to javafx.fxml;
}