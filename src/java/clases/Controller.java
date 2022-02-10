/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author brais.fernandezvazqu
 */
public class Controller {

    FParser gestorXml;
    Turno turno;
    Win win = new Win();

    public Controller() {
        gestorXml = FParser.getInstance();
        turno = new Turno();
    }

    public void pasaCasilla(int casilla) {
        gestorXml.setValor(casilla, turno.getValorCasilla());
    }

    public void limpiaCasillas() {
        gestorXml.clear();
        gestorXml.setValor(FParser.TURNO, 0);
    }

    public boolean finDePartida() {
        return turno.getTurnoNum() >= 9;
    }

    public void pasaTurno() {
        turno.addTurno();
    }

    public String cambiaValores(String cadenaFinal) {
        int[] valores = gestorXml.getCasillas();// == [0,0,0,0,0,0,0,0,0];
        String aux = "";
        for (int i = 0; i < valores.length; i++) {
            String[] subStringArray;
            switch (valores[i]) {

                case 0:
                    subStringArray = cadenaFinal.split("</td>", 2);
                    aux += subStringArray[0] + "</td>";
                    cadenaFinal = subStringArray[1];
                    break;
                case 1:
                    cadenaFinal = cadenaFinal.replaceFirst("\u200E", "X");
                    subStringArray = cadenaFinal.split("</td>", 2);
                    aux += subStringArray[0] + "</td>";
                    cadenaFinal = subStringArray[1];
                    break;
                case 2:
                    cadenaFinal = cadenaFinal.replaceFirst("\u200E", "O");
                    subStringArray = cadenaFinal.split("</td>", 2);
                    aux += subStringArray[0] + "</td>";
                    cadenaFinal = subStringArray[1];
                    break;
            }

        }

        return aux + cadenaFinal;

    }

    public boolean isFree(int casilla) {
        return gestorXml.getValor(casilla) == 0;
    }

    public boolean ganaX() {
        return win.jugador1win(gestorXml.getCasillas());
    }

    public boolean ganaO() {
        return win.jugador2win(gestorXml.getCasillas());
    }

}
