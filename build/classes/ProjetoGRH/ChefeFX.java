package ProjetoGRH;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class ChefeFX extends BorderPane {

    private Label l1, l2, l3, l4, l5, label;
    private Button finalizar, resultado;
    private HBox hboxb1, hboxb2, hboxb3, hboxb4, hboxb5, hbox;
    private VBox vbox, vBoxL1, vBoxL2, vBoxL3, vBoxL4, vBoxL5, vBoxLabels;
    private RadioButton btn0, btn1, btn2, btn3, btn4, btn5;
    private RadioButton btn6, btn7, btn8, btn9, btn10, btn11;
    private RadioButton btn12, btn13, btn14, btn15, btn16, btn17;
    private RadioButton btn18, btn19, btn20, btn21, btn22, btn23;
    private RadioButton btn24, btn25, btn26, btn27, btn28, btn29;
    private ToggleGroup btnGroup1, btnGroup2, btnGroup3, btnGroup4, btnGroup5;
    private ArrayList<Integer> valores;

    public ChefeFX() {
    }

    public void janelaChefe() {
        resultado = new Button("Média da avaliação:");
        finalizar = new Button("Finalizar avaliação");

        btnGroup1 = new ToggleGroup();
        btn0 = new RadioButton("0");
        btn0.setToggleGroup(btnGroup1);
        btn1 = new RadioButton("1");
        btn1.setToggleGroup(btnGroup1);
        btn2 = new RadioButton("2");
        btn2.setToggleGroup(btnGroup1);
        btn3 = new RadioButton("3");
        btn3.setToggleGroup(btnGroup1);
        btn4 = new RadioButton("4");
        btn4.setToggleGroup(btnGroup1);
        btn5 = new RadioButton("5");
        btn5.setToggleGroup(btnGroup1);

        btnGroup2 = new ToggleGroup();
        btn6 = new RadioButton("0");
        btn6.setToggleGroup(btnGroup2);
        btn7 = new RadioButton("1");
        btn7.setToggleGroup(btnGroup2);
        btn8 = new RadioButton("2");
        btn8.setToggleGroup(btnGroup2);
        btn9 = new RadioButton("3");
        btn9.setToggleGroup(btnGroup2);
        btn10 = new RadioButton("4");
        btn10.setToggleGroup(btnGroup2);
        btn11 = new RadioButton("5");
        btn11.setToggleGroup(btnGroup2);

        btnGroup3 = new ToggleGroup();
        btn12 = new RadioButton("0");
        btn12.setToggleGroup(btnGroup3);
        btn13 = new RadioButton("1");
        btn13.setToggleGroup(btnGroup3);
        btn14 = new RadioButton("2");
        btn14.setToggleGroup(btnGroup3);
        btn15 = new RadioButton("3");
        btn15.setToggleGroup(btnGroup3);
        btn16 = new RadioButton("4");
        btn16.setToggleGroup(btnGroup3);
        btn17 = new RadioButton("5");
        btn17.setToggleGroup(btnGroup3);

        btnGroup4 = new ToggleGroup();
        btn18 = new RadioButton("0");
        btn18.setToggleGroup(btnGroup4);
        btn19 = new RadioButton("1");
        btn19.setToggleGroup(btnGroup4);
        btn20 = new RadioButton("2");
        btn20.setToggleGroup(btnGroup4);
        btn21 = new RadioButton("3");
        btn21.setToggleGroup(btnGroup4);
        btn22 = new RadioButton("4");
        btn22.setToggleGroup(btnGroup4);
        btn23 = new RadioButton("5");
        btn23.setToggleGroup(btnGroup4);

        btnGroup5 = new ToggleGroup();
        btn24 = new RadioButton("0");
        btn24.setToggleGroup(btnGroup5);
        btn25 = new RadioButton("1");
        btn25.setToggleGroup(btnGroup5);
        btn26 = new RadioButton("2");
        btn26.setToggleGroup(btnGroup5);
        btn27 = new RadioButton("3");
        btn27.setToggleGroup(btnGroup5);
        btn28 = new RadioButton("4");
        btn28.setToggleGroup(btnGroup5);
        btn29 = new RadioButton("5");
        btn29.setToggleGroup(btnGroup5);

        hboxb1 = new HBox();
        hboxb1.getChildren()
                .addAll(btn0, btn1, btn2, btn3, btn4, btn5);

        hboxb2 = new HBox();
        hboxb2.getChildren()
                .addAll(btn6, btn7, btn8, btn9, btn10, btn11);

        hboxb3 = new HBox();
        hboxb3.getChildren()
                .addAll(btn12, btn13, btn14, btn15, btn16, btn17);

        hboxb4 = new HBox();
        hboxb4.getChildren()
                .addAll(btn18, btn19, btn20, btn21, btn22, btn23);

        hboxb5 = new HBox();
        hboxb5.getChildren()
                .addAll(btn24, btn25, btn26, btn27, btn28, btn29);

        l1 = new Label("1)\tAntes da formação, como avalia o desempenho do formando na área lecionada? \n(0 - Péssimo a 5 - Excelente)");
        l2 = new Label("2)\tVerifica no formando novas práticas benéficas relacionadas com a formação? \n(0 - Nenhuma a 5 - Bastantes)");
        l3 = new Label("3)\tDiante do feedback do formando, como avaliaria a satisfação do formando com a formação? \n(0 - Muito Insatisfeito a 5 - Muito Satisfeito)");
        l4 = new Label("4)\tDe um modo geral, como definiria a sua satisfação com o formando na formação? \n(0 - Muito Insatisfeito a 5 - Muito Satisfeito)");
        l5 = new Label("5)\tPensa recomendar mais formandos para esta formação? \n(0 - Nunca a 5 - Claramente)");

        finalizar.setOnAction(
                (ActionEvent event) -> {
                    Stage primaryStage = new Stage();
                    JanelaFinalFX root = new JanelaFinalFX();
                    Scene scene1 = new Scene(root, 300, 200);
                    primaryStage.setScene(scene1);
                    primaryStage.setTitle("Avaliação de Formação");
                    primaryStage.show();
                }
        );

        resultado.setOnAction(
                (ActionEvent event) -> {
                    RadioButton aux1 = (RadioButton) btnGroup1.getSelectedToggle();
                    RadioButton aux2 = (RadioButton) btnGroup2.getSelectedToggle();
                    RadioButton aux3 = (RadioButton) btnGroup3.getSelectedToggle();
                    RadioButton aux4 = (RadioButton) btnGroup4.getSelectedToggle();
                    RadioButton aux5 = (RadioButton) btnGroup5.getSelectedToggle();
                    valores = new ArrayList<>();
                    valores.add(Integer.parseInt(aux1.getText()));
                    valores.add(Integer.parseInt(aux2.getText()));
                    valores.add(Integer.parseInt(aux3.getText()));
                    valores.add(Integer.parseInt(aux4.getText()));
                    valores.add(Integer.parseInt(aux5.getText()));
                    label.setText(" " + media());
                }
        );

        vBoxL1 = new VBox();
        vBoxL1.getChildren().addAll(l1, hboxb1);

        vBoxL2 = new VBox();
        vBoxL2.getChildren().addAll(l2, hboxb2);

        vBoxL3 = new VBox();
        vBoxL3.getChildren().addAll(l3, hboxb3);

        vBoxL4 = new VBox();
        vBoxL4.getChildren().addAll(l4, hboxb4);

        vBoxL5 = new VBox();
        vBoxL5.getChildren().addAll(l5, hboxb5);

        vBoxLabels = new VBox();
        vBoxLabels.getChildren().addAll(vBoxL1, vBoxL2, vBoxL3, vBoxL4, vBoxL5);

        hbox = new HBox();
        label = new Label(" ");
        hbox.getChildren().addAll(resultado, label);
        vbox = new VBox();
        vbox.getChildren().addAll(hbox, finalizar);

        setCenter(vBoxLabels);
        setBottom(vbox);
    }

    private double media() {
        double media = 0;
        for (int i = 0; i < valores.size(); i++) {
            media += valores.get(i);
        }
        return media / valores.size();
    }
}
