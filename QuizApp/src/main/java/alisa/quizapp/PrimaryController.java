package alisa.quizapp;

import com.alisa.utils.MyAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("questions.fxml")).load());

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Quiz App");
        stage.show();
    }

    public void handleTest(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    @FXML
    public void handlePractice(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    @FXML
    public void handleExam(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    @FXML
    public void handleRegister(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        MyAlert.getInstance().showMsg("Comming soon...");
    }
}
