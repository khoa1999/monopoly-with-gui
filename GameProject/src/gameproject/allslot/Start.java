/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Player;

/**
 *
 * @author ThuyTrang
 */
public class Start implements Slot{
    private static Start theSlot = new Start();
    private Start() {
    }
    
    @Override
    public void toDOSomething(Player player) {

    }

    public static Start getStart(){
         return theSlot;
    }
    @Override
    public String toString(){
        return getName();
    }
    @Override
    public String getName() {
        return "Start";
    }
}
