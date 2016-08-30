/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * Contiene las oportunidades de una determinada zona del mundo
 * 
 * @author jpuriol
 */
public class ContenedorZona 
{
    private static int N_OPORTUNIDADES = 2;
    
    private Oportunidad[] oportunidades;

    public ContenedorZona()
    {
        oportunidades = new Oportunidad[N_OPORTUNIDADES];
    }
    
    /**
     * Añade un oportunidad en el número que se le pasa. Si ya hay algo se pregunta antes de reescribir
     * 
     * @param numero
     * @param op
     * @throws ExcepcionNumero 
     */
    public void añadirOportunidad (int numero, Oportunidad op) throws ExcepcionNumero
    {
        if (numero >= N_OPORTUNIDADES)
            throw new ExcepcionNumero("Se ha excedido el número máximo de la oportunidades que se puden almacenar en este contenedor según los límites actuales");
        
        if (oportunidades[numero] != null) // Si ya hay algo en este "hueco"
        {
            String[] opciones = {"Si", "No"};
            
            int eleccion = JOptionPane.showOptionDialog(null, "Una oportunidad con estas caracteristicas ya existe. ¿Quieres sobreescibirla?", "Aviso importante", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (opciones[eleccion].equals("Si"))
                oportunidades[numero] = op;
        }
        else // No hay nada en este hueco
            oportunidades[numero] = op;
    }
    
    public ArrayList dameOportunidades ()
    {
        ArrayList ops = new ArrayList();
        
        for (int i = 0; i < N_OPORTUNIDADES; i++)
            ops.add(oportunidades[i]);
        
        return ops;
    }
}
