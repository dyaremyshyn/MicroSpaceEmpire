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
    public IStates Passar() 
    {
        return new TrocaEntreRecursos(getJogo());
    }

    @Override
    public IStates EscolheExplorar_atacar()
    {
        return new EscolheNearOuUnalignedSystem(getJogo());
    }

    @Override
    public IStates EscolheConquistar() 
    {
        return new EscolheUnalignedSystem(getJogo());
    }

    @Override
    public IStates Terminar() 
    {
        return new Fim(getJogo());
    }    
}
