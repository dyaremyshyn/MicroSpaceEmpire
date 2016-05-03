/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

import java.io.Serializable;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class Tecnologia implements Serializable{
    private String nome;
    private int geracao;
    private int custo;
    
    public Tecnologia(String n , int geracao, int custo){
        nome=n;
        this.geracao = geracao;
        this.custo = custo;
    }

    @Override
    public String toString() {
        return " ->  Custo: " + custo + " " + nome + "\n";
    }

    public int getGeracao() {
        return geracao;
    }
    
    
}
