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
public class ConstruirFM_DescobrirTecnologia extends StateAdapter 
{
    
    public ConstruirFM_DescobrirTecnologia(JogoDados j) 
    {
        super(j);
    }

    @Override
    public IStates EscolheDescobrirTecnologia() {
        return super.EscolheDescobrirTecnologia(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates Aumentar_Força_Militar() {
        return super.Aumentar_Força_Militar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IStates Passar() {
        return super.Passar(); //To change body of generated methods, choose Tools | Templates.
    } 
}
