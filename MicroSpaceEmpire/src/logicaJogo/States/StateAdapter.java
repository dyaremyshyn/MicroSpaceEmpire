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
    
    public IStates PrepararJogo( ){return this;}
    public IStates Explorar_atacar(){return this;}
    public IStates Conquistar(){return this;}
    public IStates Passar(){return this;}
    public IStates Trocar_recursos(){return this;}
    public IStates Aumentar_Força_Militar(){return this;}
    public IStates Comprar_Tecnologia(){return this;}
    public IStates Terminar(){return this;}
    
    
}
