/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author xabier.barreiroalber
 */
public class Turno {

    FParser gestorXml;
    int turno;

    public Turno() {
        gestorXml = FParser.getInstance();
        turno = gestorXml.getTurno();
    }

    public boolean getTurno() {
        return turno % 2 == 0;
    }

    public int getTurnoNum() {
        return turno;
    }

    public void addTurno() {
        turno++;
        gestorXml.setValor(FParser.TURNO, turno);
    }

    int getValorCasilla() {
        return (getTurnoNum() % 2) + 1;
    }

}
