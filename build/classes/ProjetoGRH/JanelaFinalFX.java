package ProjetoGRH;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class JanelaFinalFX extends BorderPane {

    private Label questionario;
    private Button btnTerminar;

    public JanelaFinalFX() {

        questionario = new Label("Questionário terminado!!");

        btnTerminar = new Button("Terminar");
        btnTerminar.setOnAction(
                (ActionEvent event) -> {
                    System.exit(0);
                }
        );

        setCenter(questionario);
        setBottom(btnTerminar);
    }
}
