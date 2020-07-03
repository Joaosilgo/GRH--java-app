
package ProjetoGRH;

import java.io.Serializable;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public abstract class Pessoa implements Serializable{
    
    protected String nome;
    protected int idade;
    protected Genero genero;
    protected String password;
    
        public Pessoa(String nome, int idade, Genero genero, String password) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.password = password;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n Nome " + nome + "\n Idade " + idade + "\n Género " + genero;
     }   
        
}
