
package ProjetoGRH;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class Chefe extends Pessoa{

    public Chefe(String nome, int idade, Genero genero, String password) {
        super(nome, idade, genero, password);
    }

    @Override
    public String toString() {
        return super.toString() + "\n Chefe";
    }
    
}
