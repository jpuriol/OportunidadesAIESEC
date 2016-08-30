/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 * Esta clase contiene todas las oportunidades de un determinado programa, por ejemplo, global talent
 * Organizadas por las zonas en las que están.
 * 
 * Contiene también las constantes que identifican a las zonas
 * 
 * @author jpuriol
 */
public class ContenedorPrograma 
{
    private ContenedorZona[] zonas;
    
    private static final int N_ZONAS = 6; 
    
    // Constantes que identifican las Zonas
    public static final int AFRICA = 0;
    public static final int ORIENTE_MEDIO_NORTE_AFRICA = 1;
    public static final int CENTRO_ESTE_EUROPA = 2;
    public static final int ASIA_PACIFICO = 3;
    public static final int EUROPA_OCCIDENTAL_AMERICA_NORTE = 4;
    public static final int LATINOAMERICA = 5;

    public ContenedorPrograma()
    {
        zonas = new ContenedorZona[N_ZONAS];
    }
    
    public void añadirOportunidad (int zona, int numero, Oportunidad op) throws ExcepcionNumero, ExcepcionZona
    {
        if (zona >= N_ZONAS)
            throw new ExcepcionZona("Utilize por favor las constantes para referirse a las zonas");
        
        if (zonas[zona] == null)
            zonas[zona] = new ContenedorZona();
        
        zonas[zona].añadirOportunidad(numero, op);
    }
    
    /**
     * Transaforma el parámetro en una cadena corta que la identifica
     * 
     * @param zona
     * @return
     * @throws ExcepcionZona 
     */
    public static String zonaAString (int zona) throws ExcepcionZona
    {
        switch (zona)
        {
            case AFRICA:
                return "a";
            case ORIENTE_MEDIO_NORTE_AFRICA:
                return "om-na";
            case CENTRO_ESTE_EUROPA:
                return "c-ee";
            case ASIA_PACIFICO:
                return "ap";
            case EUROPA_OCCIDENTAL_AMERICA_NORTE:
                return "eo-na";
            case LATINOAMERICA:
                return "lt";
            default:
                throw new ExcepcionZona("Utilize por favor las contantes para referirse a los programas");
        }
    }
    
    /**
     *
     * @param zona
     * @return
     */
    public ArrayList dameOportunidades (int zona)
    {
        if (zonas[zona] != null)
            return zonas[zona].dameOportunidades();
        else
            return null;
    }
    
}
