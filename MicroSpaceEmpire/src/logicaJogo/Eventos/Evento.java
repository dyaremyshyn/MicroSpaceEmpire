/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.Eventos;

import java.io.Serializable;
import logicaJogo.JogoDados;


public class Evento implements Serializable {
    
    private String nome;
    
    public Evento(String n){
        nome=n;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    public void year1(JogoDados j){}
    
    public void year2(JogoDados j){}

    @Override
    public String toString() {
        return " -> " + nome + "\n";
    }
    
    
}
