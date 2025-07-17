/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package alisa.quizapp;

import com.alisa.pojo.Question;
import com.alisa.utils.Config;
import com.alisa.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {
    @FXML private TextField txtNum;
    @FXML Text txtContent;
    @FXML Text txtResult;
    @FXML VBox vboxChoices;
    
    private List<Question> questions;
    private int currentQuestion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void handleStart(ActionEvent event) throws SQLException {
        try{
            int num = Integer.parseInt(this.txtNum.getText());
            questions = Config.questionServices.getQuestions(num);
            this.currentQuestion =0;
            this.loadQuestion();
        }catch(NumberFormatException ex){
            MyAlert.getInstance().showMsg("Please! write the correct number!");
        }
    }
    
    private void loadQuestion(){
        Question q = this.questions.get(this.currentQuestion);
        ToggleGroup g = new ToggleGroup();
        this.txtContent.setText(q.getContent());
       
        for(var c:q.getChoices()){
            RadioButton rdo = new RadioButton(c.getContent());
            rdo.setToggleGroup(g);
            
            vboxChoices.getChildren().add(rdo);
            
        }
    }

    public void handleCheck(ActionEvent event) {
//        Question q = this.questions.get(this.currentQuestion);
//        for(int i =0; i< q.getChoices().size();i++){
//            if(q.getChoices().get(i).isCorrect())
//        }
    }

    public void handleNext(ActionEvent event) {

    }

}
