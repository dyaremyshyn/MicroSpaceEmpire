/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.States;

import java.io.Serializable;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public abstract class StateAdapter implements IStates , Serializable {
    
    /*private JogoDados jogo;

    public EstadoAdapter(JogoDados j) {
        this.jogo = j;
    }

    public JogoDados getJogo() {
        return jogo;
    }
*/
    
    @Override
    public IStates PrepararJogo( ){return this;}
    
    @Override
    public IStates Explorar_atacar(){return this;}
    
    @Override
    public IStates Conquistar(){return this;}
    
    @Override
    public IStates Passar(){return this;}
    
    @Override
    public IStates Trocar_recursos(){return this;}
    
    @Override
    public IStates Aumentar_Força_Militar(){return this;}
    
    @Override
    public IStates Comprar_Tecnologia(){return this;}
    
    @Override
    public IStates Terminar(){return this;}
    
    
}
