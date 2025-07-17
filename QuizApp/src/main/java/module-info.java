module com.alisa.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;



    opens alisa.quizapp to javafx.fxml;
    exports alisa.quizapp;
    exports com.alisa.pojo;
}
