/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo.Tecnologias;

/**
 *
 * @author Dmytro Yaremyshyn
 */
public class PlanetaryDefenses extends Tecnologia {

    public PlanetaryDefenses() {
        super("Planetary Defenses",2,4);
    }
    
    
    public void fazAcao(){
        
    }
    
    @Override
    public String Descricao()
    {
     return " acrescenta uma unidade de resistência durante um evento de invasão";
    }
}
