/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Board;
import java.util.Iterator;

/**
 *
 * @author ThuyTrang
 */
public class Compare {
    public static boolean isCompare(Slot a,Slot b){
        if(a.hashCode() == b.hashCode()){
            return true;
        }
        return false;
    }
    public static int getAddress(Slot a){
        for(int i= 0; i < Board.getSlots().length;i++){
            if(isCompare(Board.getSlots()[i],a)){
                return i;
            }
        }
        return -1;
    }
}
