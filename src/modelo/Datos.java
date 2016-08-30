/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpuriol
 */
public class Datos
{

    private static XStream xstream = null;
    private ContenedorOportunidades co;

    public Datos()
    {
    }

    public ContenedorOportunidades cargar()
    {
        xstream = new XStream(new DomDriver());
        xstream.alias("contenedorOp", ContenedorOportunidades.class);
        xstream.alias("contendorPro", ContenedorPrograma.class);
        xstream.alias("contenedorZo", ContenedorZona.class);
        xstream.alias("op", Oportunidad.class);

        try
        {
            FileInputStream ficheroXml = new FileInputStream(new File("src/datos.xml"));
            co = (ContenedorOportunidades) xstream.fromXML(ficheroXml);
            System.out.println("'He leído el fichero!");
        } catch (FileNotFoundException ex)
        {
            co = new ContenedorOportunidades();
        }

        return co;
    }

    public void volcar()
    {
        String xml = xstream.toXML(co);

        try
        {
            FileWriter ficheroSalidaXML = new FileWriter(new File("src/datos.xml"));
            ficheroSalidaXML.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            ficheroSalidaXML.write(xml);
            ficheroSalidaXML.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
