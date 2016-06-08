/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.util.Observable;
import logicaJogo.States.IStates;

/**
 *
 * @author Dmytro Yaremyshyn & Sergio Cruz
 */

public class ObservableGame extends Observable {
    Jogo jogo;
    
    public ObservableGame()
    {
        jogo = new Jogo();
    }
    
    public Jogo getJogo()
    {
        return jogo;
    }
    
    public void setJogo(Jogo j){
        jogo=j;
        
        setChanged();
        notifyObservers();
    }
    
    public JogoDados getJogoDados(){
        return jogo.getJogoDados();
    }
    
    public IStates getState(){
        return jogo.getStates();
    }
        
    
    // Methods retrieve data from the game
    // funcoes de consulta dos dados
    
    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    // funcoes delegadas no estado corrente 
    
    
    
}
