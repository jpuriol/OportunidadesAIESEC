package modelo;

import java.io.File;
import java.io.IOException;

/**
 *
 * Esta es la clase principal de modelo encargada de agrupar todos los datos
 * 
 * @author jpuriol
 */
public class GestorOportunidades 
{
    private ContenedorPrograma oportunidades[];

    public static final int N_PROGRAMAS = 3;
    // IDENTIFO LOS PROGRAMAS 
    public static final int GLOBAL_TALENT = 0;
    public static final int GLOBAL_ENTREPENEUR = 1;
    public static final int GLOBAL_CITIZEN = 2;
    
    public GestorOportunidades()
    {
       oportunidades = new ContenedorPrograma[N_PROGRAMAS]; 
    }
    
    public void añadirOportunidad (String ciudad, String pais, String descripcion, String url, File ficheroImagen, String programa, String localizacion, int numero) throws IOException
    {
        Oportunidad op = new Oportunidad (ciudad, pais, descripcion, url, ficheroImagen, programa, localizacion, numero);
        op.crearHtml();
    }
    
    
    public static String programaAString (int programa) throws ExcepcionPrograma
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
    
    
}
