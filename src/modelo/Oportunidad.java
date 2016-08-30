/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fichero, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import javax.swing.JOptionPane;

/**
 * Clase del modelo que representa a una oportunidad
 *
 * @author jpuriol
 */
public class Oportunidad
{

    private String ciudad;
    private String pais;
    private String descripcion; //<-------¡FALTA USARLO!
    private String url; //<-------¡FALTA USARLO!
    private int programa;
    private int zona;
    private int numero;
    private File ficheroImagen;

    public Oportunidad(String ciudad, String pais, String descripcion, String url, File ficheroImagen, int programa, int zona, int numero)
    {
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
        this.url = url;
        this.ficheroImagen = ficheroImagen;
        this.programa = programa;
        this.zona = zona;
        this.numero = numero;
    }

    /**
     *  Método que crea un ficheroPW HTML asociado a la oportunidad
     * @throws IOException
     */
    public void crearHtml() throws IOException
    {
        try
        {            
            // Creamos lo ficheros de html
            File fichero = new File("oportunidades/" + ContenedorOportunidades.programaAString(programa) + "/" + ContenedorPrograma.zonaAString(zona) + "/" + numero + ".html");
            fichero.getParentFile().mkdirs();
            
            // Copiamos el fichero que nos han dado de imagen
            String img = ContenedorOportunidades.programaAString(programa) + "_" + ContenedorPrograma.zonaAString(zona) + "_" + numero + ".png";
            File destino = new File("oportunidades/" + ContenedorOportunidades.programaAString(programa) + "/" + ContenedorPrograma.zonaAString(zona) + "/" + img);
            destino.getParentFile().mkdirs();
            
            // Falla si el fichero de la imagen ya está creado
            Files.copy(ficheroImagen.toPath(), destino.toPath());
            
            
            // falta poner codificación a UTF-8
            Writer salida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fichero), "UTF8"));
            
            salida.append("<!--Página creada automáticamente @jpuriol y @pepebnc-->").append("\n");
            salida.append("<!DOCTYPE html>").append("\n");
            salida.append("<html>").append("\n");
            
            salida.append("\t<head>").append("\n");
            salida.append("\t\t<meta charset=\"UTF-8\">").append("\n");
            salida.append("\t\t<link href=\"../css/bootstrap.css\" rel=\"stylesheet\">").append("\n");
            salida.append("\t\t<h1>¡Puedes irte a: " + ciudad + ", " + pais + "!</h1>").append("\n");
            salida.append("\t</head>").append("\n");
            
            salida.append("\t<body>").append("\n");
            salida.append("\t\t<div class=\"container\">").append("\n");
            salida.append("\t\t<title>¡Puedes irte a:" + ciudad + ", " + pais + "!</title>").append("\n");
            
            salida.append("\t\t<p><img src=\"" + img + "\" class=\"img-responsive\" height=\"500\"></p>").append("\n");
            salida.append("\t\t<p><em>¿Quieres buscar más oportunidades? Visita</em> <a href=\"https://opportunities.aiesec.org/\" target=\"_blank\">opportunities.aiesec.org</a></p>").append("\n");
            salida.append("\t\t<p><a class=\"btn btn-primary\" href=\"../../../\" role=\"button\">Volver al cuestionario</a></p>").append("\n");
            salida.append("\t\t</div>").append("\n");
            salida.append("\t</body>").append("\n");
            
            salida.append("</html>").append("\n");
            
            salida.close();
        } catch (ExcepcionPrograma ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (ExcepcionZona ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public String toString()
    {
        return  ciudad + ", " + pais + "| " + descripcion + " | -" + numero + "-";  
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public String getPais()
    {
        return pais;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public String getUrl()
    {
        return url;
    }

    public int getPrograma()
    {
        return programa;
    }

    public int getZona()
    {
        return zona;
    }

    public int getNumero()
    {
        return numero;
    }

    public File getFicheroImagen()
    {
        return ficheroImagen;
    }
    
    

}
