package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jpuriol
 */
public class Modelo 
{
    private ArrayList<Oportunidad> oportunidades;

    public Modelo()
    {
        this.oportunidades = new ArrayList<>();
    }
    
    public void añadirOportunidad (String ciudad, String pais, String descripcion, File ficheroImagen, String programa, String localizacion, int numero) throws IOException
    {
        Oportunidad op = new Oportunidad (ciudad, pais, descripcion, ficheroImagen, programa, localizacion, numero);
        op.crearHtml();
        
        oportunidades.add(op);
    }
    
    
}
