package modelo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esta es la clase principal de modelo encargada de agrupar todos los datos
 *
 * Contiene también las constantes que identifican a los programas
 *
 * @author jpuriol
 */
public class ContenedorOportunidades
{

    private ContenedorPrograma[] oportunidades;
    private static XStream xstream = null;

    private static final int N_PROGRAMAS = 3;
    // Constantes que identifican a los programas 
    public static final int GLOBAL_TALENT = 0;
    public static final int GLOBAL_ENTREPENEUR = 1;
    public static final int GLOBAL_CITIZEN = 2;

    public ContenedorOportunidades()
    {
        oportunidades = new ContenedorPrograma[N_PROGRAMAS];
    }

    public void añadirOportunidad(String ciudad, String pais, String descripcion, String url, File ficheroImagen, int programa, int zona, int numero) throws IOException, ExcepcionNumero, ExcepcionPrograma, ExcepcionZona
    {
        if (programa >= N_PROGRAMAS)
        {
            throw new ExcepcionPrograma("Por favor, utilize las constantes para referirse a los programas");
        }

        Oportunidad op = new Oportunidad(ciudad, pais, descripcion, url, ficheroImagen, programa, zona, numero);
        op.crearHtml();

        if (oportunidades[programa] == null)
        {
            oportunidades[programa] = new ContenedorPrograma();
        }

        oportunidades[programa].añadirOportunidad(zona, numero, op);
    }

    public static String programaAString(int programa) throws ExcepcionPrograma
    {
        switch (programa)
        {
            case GLOBAL_TALENT:
                return "gt";
            case GLOBAL_ENTREPENEUR:
                return "ge";
            case GLOBAL_CITIZEN:
                return "gc";
            default:
                throw new ExcepcionPrograma("Por favor. Utilize las constantes para referise a los programa");
        }
    }

    public ArrayList dameOportunidades(int zona, int programa)
    {
        if (oportunidades[programa] != null)
        {
            return oportunidades[programa].dameOportunidades(zona);
        } else
        {
            return null;
        }
    }

}
