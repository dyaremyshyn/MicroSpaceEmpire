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
public class HyperTelevision extends Tecnologia{

    public HyperTelevision() {
        super("Hyper Television",1,3);
    }
    
    @Override
    public String Descricao()
    {
     return " acrescentar uma unidade de resistência durante o evento de Revolta";
    }
}
