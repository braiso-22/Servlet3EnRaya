/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author brais.fernandezvazqu
 */
public class juego {
    int a1 = 1;
    int a2 = 2;
    int a3 = 3;
    int b1;
    int b2;
    int b3;
    int c1;
    int c2;
    int c3;
    
    
    public boolean jugador1win(){
         
        boolean traya = false;
       
        
        // FILA SUPERIOR COMPROBACIÓN DE RESULTADOS
        if(a1 == 1){
            if(a2 == 1 && a3 == 1){
               traya = true; 
            }
            if(b1 == 1 && c1 == 1){
                traya = true;
            }
            if(b2 == 1 && c3 == 1){
                traya = true;
            }  
        }
        if(a2 == 1){
            if(b2 == 1 && c2 == 1){
                traya = true;
            }  
        }
        if(a3 == 1){
            if(b2 == 1 && c1 == 1){
                traya = true;
            }
        }
        //__________________________________________________________________
        // FILA MEDIO COMPROBACIÓN DE RESULTADOS
        if(b1 == 1){
            if(b2 == 1 && b3 == 1){
               traya = true; 
            }
        }
        //_________________________________________________________________
        // FILA INFERIOR COMPROBACIÓN DE RESULTADOS
        if(c1 == 1){
            if(c2 == 1 && c3 == 1){
               traya = true; 
            }
        }
    return traya;
    
    }
    
    
    
    
    
}
