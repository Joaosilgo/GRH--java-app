
package ProjetoGRH;

/**
 *
 * @author Joâo Soares, Daniel Marques, Miguel Pires
 */
public class Formacao {
        
    String [] tabelaQuestoes = new String [4];
    
    public Formacao(){
        
        preencherTabelaQuestoes();      
    }
    
    private String[] preencherTabelaQuestoes (){
        
        this.tabelaQuestoes[0] = "Questão 1?";
        this.tabelaQuestoes[1] = "Questão 2?";
        this.tabelaQuestoes[2] = "Questão 3?";
        this.tabelaQuestoes[3] = "Questão 4?";
        this.tabelaQuestoes[4] = "Questão 5?";
        
        return this.tabelaQuestoes;
        
    }
    
}
