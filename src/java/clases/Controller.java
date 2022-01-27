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

    public void pasaCasilla(int casilla) {//getTurno de xabi como parametro boolean
        //gestorXml.pasarDatos(casilla, parOImpar)
    }

    public String cambiaValores(String cadenaFinal) {
        // int[] valores = gestorXml.getValores() == [0,0,0,0,0,0,0,0,0]
        String subString = cadenaFinal;
        cadenaFinal="";
        /*
        for(int i =0;i<valores.length;i++){
        switch(valores[i]){
        case 0:
        
            String[] subStringArray = subString.split("</td>\n", 2);
            cadenaFinal += subStringArray[0] + "</td>\n";
            subString =subStringArray[1];
        
        case 1:
        subString = subString.replaceFirst("\u200E", "X");
        case 2:
        subString = subString.replaceFirst("\u200E", "O");
        default:
        }
        cadenaFinal+=subString;
        }
         */

        return cadenaFinal;

    }
}
