/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.States;

import logicaJogo.JogoDados;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class ExplorarAtacar_Conquistar_Passar extends StateAdapter
{
    
    public ExplorarAtacar_Conquistar_Passar(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates Passar() {
        return super.Passar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates EscolheExplorar_atacar() {
        return super.EscolheExplorar_atacar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates EscolheConquistar() {
        return super.EscolheConquistar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates Terminar() {
        return new Fim(getJogo());
    }
    
    
    
}
