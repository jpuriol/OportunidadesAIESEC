/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * Excepción que indica que se ha introducido un número no válido de PROGRAMA [global talent, etc]
 * 
 * @author jpuriol
 */
public class ExcepcionPrograma extends Exception
{
    public ExcepcionPrograma(String mensaje)
    {
        super(mensaje);
    }
}
