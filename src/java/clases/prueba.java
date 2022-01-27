/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import java.util.Scanner;

/**
 *
 * @author rodrigo.garciaedreir
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GestionArchivos gestor = GestionArchivos.getInstance();
        
        Scanner teclado = new Scanner(System.in);
        
        do {
        
        System.out.println(gestor.getValor(GestionArchivos.A3));
        
        System.out.println("--------------------------------");
        
        gestor.setValor(GestionArchivos.A3, teclado.nextInt());
        
        System.out.println("actualizando");
        
        System.out.println("--------------------------------");
        
        } while (true);
        
    }
    
}
