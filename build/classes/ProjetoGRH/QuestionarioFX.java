package ProjetoGRH;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class QuestionarioFX extends BorderPane {

    private Label l1, l2, l3, l4, l5;
    private Label resultado, res;
    private TextField tf1, tf2, tf3, tf4, tf5;
    private GestorApp ga;
    private VBox vBox, vBox1;
    private Button finalizar;
    private HBox hbox;

    private float media() {
        return ((Integer.parseInt(tf1.getText()) + Integer.parseInt(tf2.getText())
                + Integer.parseInt(tf3.getText()) + Integer.parseInt(tf4.getText()) + Integer.parseInt(tf5.getText())) / 5);
    }

    public QuestionarioFX() {

        ga = new GestorApp();
        resultado = new Label("Média da avaliação: ");
        finalizar = new Button("Finalizar avaliação");
//caso chefe, estas perguntas abaixo
        l1 = new Label("Antes da formação, como avalia o desempenho do formando na área lecionada? (0 - Péssimo a 5 - Excelente)?");
        l2 = new Label("Verifica no formando novas práticas benéficas relacionadas com a formação? (0 - Nenhuma a 5 - Bastantes)?");
        l3 = new Label("Diante do feedback do formando, como avaliaria a satisfação do formando com a formação? (0 - Muito Insatisfeito a 5 - Muito Satisfeito)?");
        l4 = new Label("De um modo geral, como definiria a sua satisfação com o formando na formação? (0 - Muito Insatisfeito a 5 - Muito Satisfeito)?");
        l5 = new Label("Pensa recomendar mais formandos para esta formação? (0 - Nunca a 5 - Claramente) ?");
//caso formando, estas perguntas abaixo
//        l1 = new Label("Antes da formação, como avalia o seu desempenho? (0 - Péssimo a 5 - Excelente)?");
//        l2 = new Label("Verifica no chefe novas práticas benéficas relacionadas com a formação? (0 - Nenhuma a 5 - Bastantes)?");
//        l3 = new Label("Diante do feedback do chefe, como avaliaria a satisfação do chefe para com o seu desempenho na formação? (0 - Muito Insatisfeito a 5 - Muito Satisfeito)?");
//        l4 = new Label("De um modo geral, como definiria a sua relação com o chefe? (0 - Muito Insatisfeito a 5 - Muito Satisfeito)?");
//        l5 = new Label("Pensa recomendar mais formandos para esta formação? (0 - Nunca a 5 - Claramente) ?");
        
        
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();

        {
            if (ga.isNotaValida(Integer.parseInt(tf1.getText()))
                    && ga.isNotaValida(Integer.parseInt(tf2.getText()))
                    && ga.isNotaValida(Integer.parseInt(tf3.getText()))
                    && ga.isNotaValida(Integer.parseInt(tf4.getText()))
                    && ga.isNotaValida(Integer.parseInt(tf5.getText()))) {
                res.setText("" + media());
            }
        }

        finalizar.setOnAction(
                (ActionEvent event) -> {
                    Stage primaryStage = new Stage();
                    JanelaFinalFX root = new JanelaFinalFX();
                    Scene scene1 = new Scene(root, 300, 200);
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                }
        );

        vBox = new VBox();
        vBox.getChildren().addAll(l1, tf1, l2, tf2, l3, tf3, l4, tf4, l5, tf5);
        hbox = new HBox();
        hbox.getChildren().addAll(finalizar, resultado, res);

        vBox1 = new VBox();
        vBox1.getChildren().addAll(vBox, hbox);
    }
}
