/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * Excepción que indica que se ha introducido un número no válido de ZONA [del mundo]
 * 
 * @author jpuriol
 */
public class ExcepcionZona extends Exception
{

    public ExcepcionZona(String message)
    {
        super(message);
    }
}
