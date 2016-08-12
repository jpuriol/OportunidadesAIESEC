/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 * Esta clase contiene todas las oportunidades de un determinado programa, por ejemplo, global talent
 * Organizadas por las zonas en las que están.
 * 
 * @author jpuriol
 */
public class ContenedorPrograma 
{
    private ContenedorZona[] zonas;
    
    public static final int N_ZONAS = 6; 
    
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
    
}
