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
public class turno {
    int turno = 0;
        
    public boolean getTurno(){
        if(turno % 2 == 0){
            return true;
        }
        else return false;
    }
    
    public int getTurnoNum(){
        return turno;
    }
    
    public void addTurno(){
        
    }
    
}
