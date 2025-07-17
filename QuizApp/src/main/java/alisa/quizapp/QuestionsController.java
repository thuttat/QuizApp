/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package alisa.quizapp;

import com.alisa.pojo.Categories;
import com.alisa.pojo.Choice;
import com.alisa.pojo.Level;
import com.alisa.pojo.Question;
import com.alisa.services.CategoriesServices;
import com.alisa.services.LevelServices;
import com.alisa.services.QuestionServices;
import com.alisa.utils.Config;
import com.alisa.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private ComboBox<Categories> cbCates;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private VBox vboxChoice;
    @FXML
    private TextArea txtContent;
    @FXML
    private ToggleGroup toggleChoice;
    @FXML
    private TableView<Question> tbQuestion;
    @FXML
    private TextField txtSearch;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(Config.cateServices.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(Config.levelServices.getLevels()));
            this.loadColums();
            this.tbQuestion.setItems(FXCollections.observableList(Config.questionServices.getQuestions()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.txtSearch.textProperty().addListener(e -> {
            try {
                this.tbQuestion.getItems().clear();
                this.tbQuestion.setItems(FXCollections.observableList(Config.questionServices.getQuestions(this.txtSearch.getText())));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }

    public void addChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Main");

        RadioButton rdo = new RadioButton();
        rdo.setToggleGroup(toggleChoice);
        TextField txt = new TextField();

        h.getChildren().addAll(rdo, txt);
        this.vboxChoice.getChildren().add(h);

    }

    public void addQuestion(ActionEvent event) {

        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());

            for (var c : this.vboxChoice.getChildren()) {
                HBox h = (HBox) c;

                Choice choice = new Choice(((TextField) h.getChildren().get(1)).getText(), ((RadioButton) h.getChildren().get(0)).isSelected());

                b.addChoice(choice);

            }

            Config.questionServices.addQuestion(b.build());
            MyAlert.getInstance().showMsg("Success");
        } catch (SQLException ex) {
            MyAlert.getInstance().showMsg("can not adding, cause " + ex.getMessage());
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg(":((!");
        }
    }

    private void loadColums() {
        TableColumn colId = new TableColumn("id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);
        TableColumn colContent = new TableColumn("content");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(250);

        this.tbQuestion.getColumns().addAll(colId, colContent);

    }
}
