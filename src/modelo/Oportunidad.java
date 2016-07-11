/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fichero, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
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
    private String programa;
    private String localizacion;
    private int numero;
    private File ficheroImagen;

    public Oportunidad(String ciudad, String pais, String descripcion, String url, File ficheroImagen, String programa, String zonaMundo, int numero)
    {
        this.ciudad = ciudad;
        this.pais = pais;
        this.descripcion = descripcion;
        this.url = url;
        this.ficheroImagen = ficheroImagen;
        this.programa = programa;
        this.localizacion = zonaMundo;
        this.numero = numero;
    }

    /**
     *  Métoco que crea un ficheroPW HTML asociado a la oportunidad
     * @throws IOException
     */
    public void crearHtml() throws IOException
    {
        // Creamos el nombre de la ficheroImagen
        String img = programa + "_" + localizacion + "_" + numero + ".png";
        
        // Creamos lo ficheros de html
        File fichero = new File("oportunidades/" + programa + "/" + localizacion + "/" + numero + ".html");
        fichero.getParentFile().mkdirs();
        
        // Copiamos el fichero que nos han dado de imagen
        File destino = new File("oportunidades/" + programa + "/" + localizacion + "/" + img);
        destino.getParentFile().mkdirs();
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
    }

}
