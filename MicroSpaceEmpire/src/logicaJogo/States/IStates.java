/**
 *
 * @authors Dmytro Yaremyshyn and Sérgio Cruz
 */


package logicaJogo.States;


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
