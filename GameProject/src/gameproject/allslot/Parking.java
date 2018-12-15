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
public class Parking implements Slot {
    public Parking(){
    
    }
    @Override
    public void toDOSomething(Player player) {
    }
    @Override
    public String toString(){
        return "Parking slot";
    }

    @Override
    public String getName() {
        return toString();
    }
}

