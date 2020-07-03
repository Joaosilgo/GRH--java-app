package ProjetoGRH;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class GRH_AvaliacaoDesempenhoFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        JanelaPrincipalFX root = new JanelaPrincipalFX();
        root.janela();
        root.getChildren();

        Scene scene;
        scene = new Scene(root, 500, 400);

        primaryStage.setTitle("Avaliação da Formação");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        GestorApp ga = new GestorApp();
    }

}
