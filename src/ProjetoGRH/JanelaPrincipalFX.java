package ProjetoGRH;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class JanelaPrincipalFX extends BorderPane {

    private Label bemvindo;
    private Button btnCriar, btnAutenticar;
    private RadioButton btnChefe, btnFormando;
    private Image i;
    private ImageView img;
    private Label nome, password, idade, genero, cargo;
    private TextField txtNome, txtPassword, txtIdade;
    private HBox HBoxnome, HBoxpassword, HBoxidade, HBoxgenero, HBoxCargo, HBoxBotao;
    private VBox VBoxTudo;
    private ComboBox generoBox;
    private ToggleGroup cargoGroup;
    private String auxPassword;

    public JanelaPrincipalFX() {
    }

    public void janela() {

        bemvindo = new Label("Bem Vindo!");
        i = new Image(getClass().getResourceAsStream("AvaliacaoFormacao.jpg"));
        img = new ImageView(i);
        img.setFitHeight(150);
        img.setFitWidth(500);

        ObservableList<Genero> options
                = FXCollections.observableArrayList(
                        Genero.M, Genero.F
                );
        cargoGroup = new ToggleGroup();
        btnChefe = new RadioButton("Chefe");
        btnChefe.setToggleGroup(cargoGroup);
        btnFormando = new RadioButton("Formando");
        btnFormando.setToggleGroup(cargoGroup);

        nome = new Label("Introduzir nome: ");
        password = new Label("Introduzir password: ");
        idade = new Label("Introduzir idade: ");
        genero = new Label("Selecionar género: ");
        cargo = new Label("Selecionar cargo: ");

        txtNome = new TextField();
        txtPassword = new PasswordField();
        txtIdade = new TextField();
        generoBox = new ComboBox(options);

        HBoxnome = new HBox();
        HBoxnome.getChildren()
                .addAll(nome, txtNome);

        HBoxpassword = new HBox();
        HBoxpassword.getChildren()
                .addAll(password, txtPassword);
        auxPassword = txtPassword.getText();

        HBoxidade = new HBox();
        HBoxidade.getChildren()
                .addAll(idade, txtIdade);

        HBoxgenero = new HBox();
        HBoxgenero.getChildren()
                .addAll(genero, generoBox);

        HBoxCargo = new HBox();
        HBoxCargo.getChildren()
                .addAll(cargo, btnChefe, btnFormando);

        btnCriar = new Button("Criar");
        btnCriar.setOnAction(
                (ActionEvent event) -> {
                    Stage primaryStage = new Stage();
                    CriarUtilizadorFX root = new CriarUtilizadorFX();
                    Scene scene1 = new Scene(root, 300, 100);
                    primaryStage.setScene(scene1);
                    primaryStage.show();
                }
        );

        btnAutenticar = new Button("Autenticar");
        btnAutenticar.setOnAction(
                (ActionEvent event) -> {
                    if (btnChefe.isSelected()) {
                        Stage Stage1 = new Stage();
                        ChefeFX root1 = new ChefeFX();
                        root1.janelaChefe();
                        root1.getChildren();
                        Scene scene1 = new Scene(root1, 600, 400);
                        Stage1.setScene(scene1);
                        Stage1.setTitle("Questionário Chefe");
                        Stage1.show();
                    } else if (btnFormando.isSelected()) {
                        Stage Stage2 = new Stage();
                        FormandoFX root2 = new FormandoFX();
                        root2.janelaFormando();
                        root2.getChildren();
                        Scene scene2 = new Scene(root2, 600, 400);
                        Stage2.setScene(scene2);
                        Stage2.setTitle("Questionário Formando");
                        Stage2.show();
                    }
                }
        );

        HBoxBotao = new HBox();

        HBoxBotao.getChildren()
                .addAll(btnCriar, btnAutenticar);
        VBoxTudo = new VBox();

        VBoxTudo.getChildren()
                .addAll(HBoxnome, HBoxpassword, HBoxidade, HBoxgenero, HBoxCargo, HBoxBotao);
        setTop(bemvindo);

        setCenter(VBoxTudo);

        setBottom(img);
    }
}
