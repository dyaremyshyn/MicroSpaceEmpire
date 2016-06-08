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
    
    public void PrepararJogo()
    {
        jogo.PrepararJogo();
        
        setChanged();
        notifyObservers();
    }

    public void Explorar_atacar(int TipoSistema) 
    {
        jogo.Explorar_atacar(TipoSistema);
        
        setChanged();
        notifyObservers();
    }

    public void Conquistar(int alvo)
    {
        jogo.Conquistar(alvo);
        
        setChanged();
        notifyObservers();
    }

    public void Passar()
    {
        jogo.Passar();
        
        setChanged();
        notifyObservers();
    }    
    
    public void Trocar_recursos(int TipoDeTroca) 
    {
        jogo.Trocar_recursos(TipoDeTroca);
        
        setChanged();
        notifyObservers();
    }

    public void Aumentar_Força_Militar() 
    {
        jogo.Aumentar_Força_Militar();
        
        setChanged();
        notifyObservers();
    }

    public void Comprar_Tecnologia(int TecnologiaEscolhida)
    {
        jogo.Comprar_Tecnologia(TecnologiaEscolhida);
        
        setChanged();
        notifyObservers();
    }

    public void Terminar()
    {
        jogo.Terminar();
        
        setChanged();
        notifyObservers();
    }
    
    public void EscolheExplorar_atacar()  
    {
        jogo.EscolheExplorar_atacar();
        
        setChanged();
        notifyObservers();
    }

    public void EscolheConquistar()
    {
        jogo.EscolheConquistar();
        
        setChanged();
        notifyObservers();
    }

    public void Cancelar()
    {
        jogo.Cancelar();
        
        setChanged();
        notifyObservers();
    }
    
    public void EscolheDescobrirTecnologia()
    {
        jogo.EscolheDescobrirTecnologia();
        
        setChanged();
        notifyObservers();
    }
}
