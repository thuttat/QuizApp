module com.alisa.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires lombok;


    opens alisa.quizapp to javafx.fxml;
    exports alisa.quizapp;
}
