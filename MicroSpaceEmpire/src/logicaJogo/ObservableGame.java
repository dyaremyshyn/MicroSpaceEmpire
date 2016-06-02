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
    
    
    // FALTA COMPLETAR 
    //....
    
    
    // Methods that are intended to be used by the user interfaces and that are delegated in the current state of the finite state machine 
    
    public void setNumberPlayers(int num)
    {
        gameModel.setNumberPlayers(num);
        
        setChanged();
        notifyObservers();
    }

    public void setPlayerName(int num, String name) 
    {
        gameModel.setPlayerName(num, name);
        
        setChanged();
        notifyObservers();
    }

    public void startGame()
    {
        gameModel.startGame();
        
        setChanged();
        notifyObservers();
    }

    public void placeToken(int line, int column)
    {
        gameModel.placeToken(line, column);
        
        setChanged();
        notifyObservers();
    }

    public void returnToken(int line, int column)
    {
        gameModel.returnToken(line, column);
        
        setChanged();
        notifyObservers();
    }

    public void quit()
    {
        gameModel.quit();
        
        setChanged();
        notifyObservers();
    }
    
    
    
}
