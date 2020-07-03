package ProjetoGRH;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class CriarUtilizadorFX extends BorderPane {

    private Label criado;

    public CriarUtilizadorFX() {
        criado = new Label("Utilizador Criado!!");
        setCenter(criado);
    }
}
