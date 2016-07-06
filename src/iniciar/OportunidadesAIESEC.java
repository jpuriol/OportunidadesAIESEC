/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciar;

import controlador.Controlador;
import modelo.Modelo;
import vista.VentanaPrincipal;

/**
 *
 * @author admin
 */
public class OportunidadesAIESEC
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Modelo m = new Modelo();
        Controlador c = new Controlador (m);
        VentanaPrincipal v = new VentanaPrincipal (c);
        v.setVisible(true);
    }
    
}
