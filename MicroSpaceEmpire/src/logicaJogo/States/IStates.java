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
    IStates Explorar_atacar(int TipoSistema);
    IStates Conquistar(int alvo);
    IStates Passar();
    IStates Trocar_recursos(int TipoDeTroca);
    IStates Aumentar_Força_Militar();
    IStates Comprar_Tecnologia(int TecnologiaEscolhida);
    IStates Terminar();
    IStates EscolheExplorar_atacar();
    IStates EscolheConquistar();
    IStates Cancelar();
    IStates EscolheDescobrirTecnologia();
    
}
