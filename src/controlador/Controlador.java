/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;
import java.io.IOException;
import modelo.Modelo;

/**
 *
 * @author jpuriol
 */
public class Controlador 
{
    Modelo m;

    public Controlador(Modelo m)
    {
        this.m = m;
    }

    public void añadirOportunidad(String ciudad, String pais, String descripcion, String url, File ficheroImagen, String programa, String localizacion, int numero) throws IOException
    {
        m.añadirOportunidad(ciudad, pais, descripcion, url, ficheroImagen, programa, localizacion, numero);
    }
    
}
