package ProjetoGRH;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class GestorApp implements Serializable {

    private int nota1, nota2, nota3, nota4, nota5;
    double media;

    private Scanner sc;
    private Pessoa pessoa;
    private String nome;
    private String password;
    private int idade;
    private Genero genero;
    private final ArrayList<Pessoa> listaEntervistados;

    public GestorApp() {
        sc = new Scanner(System.in);
        listaEntervistados = new ArrayList<>();
        iniciarApp();
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public void login(String nome, String password) {
        for (Pessoa p : getListaEntervistados()) {
            if (nome.equals(p.getNome())) {
            }
        }
    }

    public void iniciarApp() {
    }

    public void registar() {
        escolherCategoria();
        System.out.println("Registado com Sucesso");
        iniciarApp();
    }

    public void autenticar() {
        String nomeAux;
        String passAux;
        nomeAux = pedirNome();
        passAux = pedirPassword();
        for (int i = 0; i < getListaEntervistados().size(); i++) {
            if (nomeAux.equals(getListaEntervistados().get(i).getNome()) && passAux.equals(getListaEntervistados().get(i).getPassword())) {
                if (getListaEntervistados().get(i) instanceof Chefe) {
                    fazerPerguntasChefe();
                } else {
                    fazerPerguntasFormando();
                }
            }
        }
    }

    public boolean isNotaValida(int nota) {
        if (nota >= 0 && nota <= 5) {
            return true;
        }
        return false;
    }

    private void escolherCategoria() {
        String auxNome = pedirNome();
        String auxPassword = pedirPassword();
        int auxIdade = pedirIdade();
        Genero auxGenero = pedirGenero();

        int p;

        System.out.println("\n1 - Chefe | 2 - Formando?");
        p = sc.nextInt();

        switch (p) {
            case 1:
                this.pessoa = new Chefe(auxNome, auxIdade, auxGenero, auxPassword);
                break;
            case 2:
                this.pessoa = new Formando(auxNome, auxIdade, auxGenero, auxPassword);
                break;
            default:
                System.out.println("Pessoa não encontrada");
                escolherCategoria();

        }
        listaEntervistados.add(pessoa);
        String fileName = "data.txt";
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
            os.writeObject(listaEntervistados);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(pessoa);
    }

    private String pedirNome() {

        System.out.println("\nIntroduza o seu nome: \n");
        this.nome = sc.next();
        if (this.nome == null || "".equals(nome)) {
            System.out.println("\n Nome inválido!");
            pedirNome();
        }
        return this.nome;
    }

    private String pedirPassword() {
        System.out.println("\nIntroduza a sua password: \n");
        this.password = sc.next();
        if (this.password == null || "".equals(password)) {
            System.out.println("\n Password inválida!");
            pedirPassword();
        }
        return this.password;
    }

    private int pedirIdade() {
        do {
            System.out.println("\nIntroduza a sua idade: \n");
            idade = sc.nextInt();
        } while (idade <= 0 || idade > 100);

        return this.idade;
    }

    private Genero pedirGenero() {
        String opcao;
        System.out.println("\nIntroduza o seu genero (M / F): \n");
        opcao = sc.next().toUpperCase();
        switch (opcao) {
            case "M":
                this.genero = Genero.M;
                break;
            case "F":
                this.genero = Genero.F;
                break;
            default:
                System.out.println("Género indefenido");
        }
        return this.genero;
    }

    public ArrayList<Pessoa> getListaEntervistados() {
        return listaEntervistados;
    }

    public double fazerPerguntasFormando() {
        System.out.println("\n########## Iniciar questionário ao formando ##########");
        do {
            System.out.println("\nAntes da formação, como avalia o seu desempenho? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota1 = sc.nextInt();
        } while (this.nota1 < 0 || this.nota1 > 5);

        do {
            System.out.println("\nVerifica no chefe novas práticas benéficas relacionadas com a formação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota2 = sc.nextInt();
        } while (this.nota2 < 0 || this.nota2 > 5);

        do {
            System.out.println("\nDiante do feedback do chefe, como avaliaria a satisfação do chefe para com o seu desempenho na formação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota3 = sc.nextInt();
        } while (this.nota3 < 0 || this.nota3 > 5);

        do {
            System.out.println("\nDe um modo geral, como definiria a sua relação com o chefe? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota4 = sc.nextInt();
        } while (this.nota4 < 0 || this.nota4 > 5);

        do {
            System.out.println("\nPensa recomendar mais formandos para esta formaçã? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota5 = sc.nextInt();
        } while (this.nota5 < 0 || this.nota5 > 5);

        media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;
        System.out.println("\nA média é " + media);
        iniciarApp();
        return media;
    }

    public double fazerPerguntasChefe() {
        System.out.println("\n########## Iniciar questionário ao Chefe ##########");
        do {
            System.out.println("\nAntes da formação, como avalia o desempenho do formando na área lecionada? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota1 = sc.nextInt();
        } while (this.nota1 < 0 || this.nota1 > 5);

        do {
            System.out.println("\nVerifica no formando novas práticas benéficas relacionadas com a formação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota2 = sc.nextInt();
        } while (this.nota2 < 0 || this.nota2 > 5);

        do {
            System.out.println("\nDiante do feedback do formando, como avaliaria a satisfação do formando com a formação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota3 = sc.nextInt();
        } while (this.nota3 < 0 || this.nota3 > 5);

        do {
            System.out.println("\nDe um modo geral, como definiria a sua satisfação com o formandoformação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota4 = sc.nextInt();
        } while (this.nota4 < 0 || this.nota4 > 5);

        do {
            System.out.println("\nPensa recomendar mais formandos para esta formação? \n(0-Pessimo , 1-Muito Insatisfatorio, 2-Insastifatorio, 3-Satisfatirio, 4-Bom, 5-Exelente)");
            this.nota5 = sc.nextInt();
        } while (this.nota5 < 0 || this.nota5 > 5);

        media = (nota1 + nota2 + nota3 + nota4 + nota5) / 5;
        System.out.println("\nA média é " + media);
        iniciarApp();
        return media;
    }

}
