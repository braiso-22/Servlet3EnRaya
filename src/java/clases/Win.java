
package clases;

/**
 *
 * @author xabier.barreiroalber
 */
public class Win {

    FParser gestorXml = FParser.getInstance();
    int a1;     // Variable que representa la casilla "A1" del .xml
    int a2;     // Variable que representa la casilla "A2" del .xml
    int a3;     // Variable que representa la casilla "A3" del .xml      
    int b1;     // Variable que representa la casilla "B1" del .xml
    int b2;     // Variable que representa la casilla "B2" del .xml
    int b3;     // Variable que representa la casilla "B3" del .xml
    int c1;     // Variable que representa la casilla "C1" del .xml
    int c2;     // Variable que representa la casilla "C2" del .xml
    int c3;     // Variable que representa la casilla "C3" del .xml

    
    /* Método que devuelve "true" en caso de que el jugador con turno par,
    es decir, el jugador número 1 consigue 3 en raya. */
    public boolean jugador1win(int[] casillas) {
        
        a1 = casillas[0];       // Inicialización de la variable "a1"
        a2 = casillas[1];       // Inicialización de la variable "a2"
        a3 = casillas[2];       // Inicialización de la variable "a3"
        b1 = casillas[3];       // Inicialización de la variable "b1"
        b2 = casillas[4];       // Inicialización de la variable "b2"
        b3 = casillas[5];       // Inicialización de la variable "b3"
        c1 = casillas[6];       // Inicialización de la variable "c1"
        c2 = casillas[7];       // Inicialización de la variable "c2"
        c3 = casillas[8];       // Inicialización de la variable "c3"
        boolean traya = false;  // Variable que representa el caso de 3 en raya
        //_________________________________________________________________
        /* Comprobación de resultados empezando por la fila superior, es decir,
        el conjunto de "a". */
        if (a1 == 1) {
            
            // Si a1, a2 y a3 son 1 devuelve "true"
            if (a2 == 1 && a3 == 1) {
                traya = true;
            }
            
            // Si a1, b1 y c1 son 1 devuelve "true"
            if (b1 == 1 && c1 == 1) {
                traya = true;
            }
            
            // Si a1, b2 y c3 son 1 devuelve "true"
            if (b2 == 1 && c3 == 1) {
                traya = true;
            }
        }
        if (a2 == 1) {
            
            // Si a2, b2 y c2 son 1 devuelve "true"
            if (b2 == 1 && c2 == 1) {
                traya = true;
            }
        }
        if (a3 == 1) {
            
            // Si a3, b2 y c1 son 1 devuelve "true"
            if (b2 == 1 && c1 == 1) {
                traya = true;
            }
            
            // Si a3, b3 y c3 son 1 devuelve "true"
            if (b3 == 1 && c3 == 1) { 
                traya = true;
            }
        }
        //__________________________________________________________________
        /* Comprobación de resultados empezando por la fila del medio, es decir,
        el conjunto de "b". */
        if (b1 == 1) {
            
            // Si b1, b2 y b3 son 1 devuelve "true"
            if (b2 == 1 && b3 == 1) {
                traya = true;
            }
        }
        //_________________________________________________________________
        /* Comprobación de resultados empezando por la fila inferior, es decir,
        el conjunto de "c". */
        if (c1 == 1) {
            
            // Si c1, c2 y c3 son 1 devuelve "true"
            if (c2 == 1 && c3 == 1) {
                traya = true;
            }
        }
        return traya;

    }
//----------------------------------------------------------------------------//
    /* Método que devuelve "true" en caso de que el jugador con turno impar,
    es decir, el jugador número 2 consigue 3 en raya. */
    public boolean jugador2win(int[] casillas) {
        
        a1 = casillas[0];       // Inicialización de la variable "a1".
        a2 = casillas[1];       // Inicialización de la variable "a2".
        a3 = casillas[2];       // Inicialización de la variable "a3".
        b1 = casillas[3];       // Inicialización de la variable "b1".
        b2 = casillas[4];       // Inicialización de la variable "b2".
        b3 = casillas[5];       // Inicialización de la variable "b3".
        c1 = casillas[6];       // Inicialización de la variable "c1".
        c2 = casillas[7];       // Inicialización de la variable "c2".
        c3 = casillas[8];       // Inicialización de la variable "c3".
        boolean traya = false;  // Variable que representa el caso de 3 en raya.

        //_________________________________________________________________
        /* Comprobación de resultados empezando por la fila superior, es decir,
        el conjunto de "a". */
        if (a1 == 2) {
            
            // Si a1, a2 y a3 son 2 devuelve "true"
            if (a2 == 2 && a3 == 2) {
                traya = true;
            }
            
            // Si a1, b1 y c1 son 2 devuelve "true"
            if (b1 == 2 && c1 == 2) {
                traya = true;
            }
            
            // Si a1, b2 y c3 son 2 devuelve "true"
            if (b2 == 2 && c3 == 2) {
                traya = true;
            }
        }
        if (a2 == 2) {
            
            // Si a2, b2 y c2 son 2 devuelve "true"
            if (b2 == 2 && c2 == 2) {
                traya = true;
            }
        }
        if (a3 == 2) {
            
            // Si a3, b2 y c1 son 2 devuelve "true"
            if (b2 == 2 && c1 == 2) {
                traya = true;
            }
            
            // Si a3, b3 y c3 son 2 devuelve "true"
            if (b3 == 2 && c3 == 2) {
                traya = true;
            }
        }
        //__________________________________________________________________
        /* Comprobación de resultados empezando por la fila del medio, es decir,
        el conjunto de "b". */
        if (b1 == 2) {
            
            // Si b1, b2 y b3 son 2 devuelve "true"
            if (b2 == 2 && b3 == 2) {
                traya = true;
            }
        }
        //_________________________________________________________________
        /* Comprobación de resultados empezando por la fila inferior, es decir,
        el conjunto de "c". */
        if (c1 == 2) {
            
            // Si c1, c2 y c3 son 2 devuelve "true"
            if (c2 == 2 && c3 == 2) {
                traya = true;
            }
        }
        return traya;

    }

}
