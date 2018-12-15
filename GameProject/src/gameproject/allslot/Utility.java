/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Board;
import gameproject.Dice;
import gameproject.Player;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author ThuyTrang
 */
public class Utility extends Property{
    private Hashtable<Player,Integer> listOfOwners = 
            new Hashtable<>();    
    public Utility(String name){ 
        this.purchaseCost = 150;
        LinkedList list = Board.getPlayers();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Player i = (Player)it.next();
            listOfOwners.put(i,new Integer(0));
        }        
    }
    @Override
    public int calculateTax() {
        if(this.owner == null){
            return 0;
        }
        if(listOfOwners.get(this.owner)
                .equals(new Integer(1))){
            return this.current.h*4;
        }
        return this.current.h*10;        
    }
    @Override
    public String getName() {
       return "Utility";
    }

    @Override
    public void setMortaged() {
        this.setMortagedd();
    }

    @Override
    public void sell() {
        this.owner.getPersonAcc().changeAmount(-purchaseCost);
        this.free();
    }

    @Override
    public void buy(Player player) {
        this.buyy(player);
        this.listOfOwners.replace(player,
                new Integer(this.listOfOwners.get(player).intValue() + 1));
    }
    @Override
    public void free() {
       this.listOfOwners.replace(owner, new Integer(
               this.listOfOwners.get(this.owner).intValue()- 1));
       super.freee();
    }
}
