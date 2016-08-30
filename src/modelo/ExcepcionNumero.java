/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * Se usa cuando el número de la oportunidad es incorrecta
 * 
 * @author jpuriol
 */
public class ExcepcionNumero extends Exception
{

    public ExcepcionNumero(String message)
    {
        super(message);
    }
}
