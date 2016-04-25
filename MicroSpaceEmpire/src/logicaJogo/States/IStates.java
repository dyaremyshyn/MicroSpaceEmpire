/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.States;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public interface IStates {
    
    IStates PrepararJogo();
    IStates Explorar_atacar();
    IStates Conquistar();
    IStates Passar();
    IStates Trocar_recursos();
    IStates Aumentar_Força_Militar();
    IStates Comprar_Tecnologia();
    IStates Terminar();
    
}
