/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Tecnologias;

import java.io.Serializable;
import logicaJogo.JogoDados;


public class Tecnologia implements Serializable, Constantes_tecnologias{
    private String nome;
    private int geracao;
    private int custo;
    
    public Tecnologia(String n , int geracao, int custo){
        nome = n;
        this.geracao = geracao;
        this.custo = custo;
    }

    @Override
    public String toString() {
        return " ->  Custo: " + custo + " | " + nome + " | " + " descrição: " + Descricao() + "\n";
    }

    public int getGeracao() {
        return geracao;
    }

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }     
    
    public void FazAccao(JogoDados jogo)
    {    
    }
    
    public String Descricao()
    {
    return "";
    }
    
    
}
