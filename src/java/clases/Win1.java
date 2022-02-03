/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author brais.fernandezvazqu
 */
public class Win1 {
    int a1;
    int a2;
    int a3;
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
//----------------------------------------------------------------------------//
 
    public boolean jugador2win(){
         
        boolean traya = false;
       
        
        // FILA SUPERIOR COMPROBACIÓN DE RESULTADOS
        if(a1 == 2){
            if(a2 == 2 && a3 == 2){
               traya = true; 
            }
            if(b1 == 2 && c1 == 2){
                traya = true;
            }
            if(b2 == 2 && c3 == 2){
                traya = true;
            }  
        }
        if(a2 == 2){
            if(b2 == 2 && c2 == 2){
                traya = true;
            }  
        }
        if(a3 == 2){
            if(b2 == 2 && c1 == 2){
                traya = true;
            }
        }
        //__________________________________________________________________
        // FILA MEDIO COMPROBACIÓN DE RESULTADOS
        if(b1 == 2){
            if(b2 == 2 && b3 == 2){
               traya = true; 
            }
        }
        //_________________________________________________________________
        // FILA INFERIOR COMPROBACIÓN DE RESULTADOS
        if(c1 == 2){
            if(c2 == 2 && c3 == 2){
               traya = true; 
            }
        }
    return traya;
    
    }
    
    
    
    
    
}

    
    
    
    
