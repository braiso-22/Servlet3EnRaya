package clases;

/**
 *
 * @author xabier.barreiroalber
 */

// Clase que gestiona el turno recojido del ".xml".
public class Turno {
    
    FParser gestorXml;
    int turno;

    /* Constructor de la clase que obtiene una instancia de FParser y 
    inicializa turno. */
    public Turno() {
        gestorXml = FParser.getInstance();
        turno = gestorXml.getTurno();
    }

    /* Método creado para obtener "true" o "false" en funcion de si el turno
    es par o no respectivamente. */
    public boolean getTurno() {
        return turno % 2 == 0;
    }

    // Método que devuelve el turno actual guardado en el ".xml" como un "int".
    public int getTurnoNum() {
        return turno;
    }

    // Método que añade un turno sumando "1" al turno obtenido del ".xml".
    public void addTurno() {
        turno++;
        gestorXml.setValor(FParser.TURNO, turno);   // Escribe en el ".xml".
    }

    /* Devuelve el turno siguiente a escribir en el ".xml" el valor, es decir,
    "X" o "O" en función de si turno es par o impar. */
    int getValorCasilla() {
        return (getTurnoNum() % 2) + 1;
    }

}
