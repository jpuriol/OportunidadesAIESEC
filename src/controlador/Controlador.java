/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ContenedorOportunidades;
import modelo.ExcepcionNumero;
import modelo.ExcepcionPrograma;
import modelo.ExcepcionZona;

/**
 *
 * @author jpuriol
 */
public class Controlador 
{
    ContenedorOportunidades m;

    public Controlador(ContenedorOportunidades m)
    {
        this.m = m;
    }

    public void añadirOportunidad(String ciudad, String pais, String descripcion, String url, File ficheroImagen, int programa, int zona, int numero) throws IOException, ExcepcionNumero, ExcepcionPrograma, ExcepcionZona
    {
        m.añadirOportunidad(ciudad, pais, descripcion, url, ficheroImagen, programa, zona, numero);
    }
    
    public ArrayList dameOportunidades (int programa, int zona)
    {
        return m.dameOportunidades(zona, programa);
    }
}
