module com.axs.pos {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires mysql.connector.java;

    opens com.axs.pos to javafx.fxml;
    exports com.axs.pos;
    exports com.axs.pos.Controllers;
    exports com.axs.pos.Controllers.Admin;
    exports com.axs.pos.Controllers.Client;
    exports com.axs.pos.Models;
    exports com.axs.pos.Views;
}