/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

/**
 *
 * @author ThuyTrang
 */
import gameproject.Board;
import gameproject.Board;
import gameproject.Player;
import gameproject.Player;
import gameproject.allslot.Property;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class RailRoad extends Property{

    private static int numRail;

    private Hashtable<Player,Integer> listOfOwners = 
            new Hashtable<>();

    public RailRoad(){
        this.purchaseCost = 200;
        Board theBoard = Board.getBoard();
        LinkedList list = Board.getPlayers();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Player i = (Player)it.next();
            listOfOwners.put(i,new Integer(0));
        }
    }
    @Override
    public void buy(Player player){
        super.buyy(player);
        this.listOfOwners.replace(owner,
                new Integer(this.listOfOwners.get(player).intValue()+1));
    }
    @Override
    public int calculateTax(){
        if(this.owner == null){
            return 0;
        }
        if(listOfOwners.get(this.owner)
                .equals(new Integer(1))){
            return 25;
        }
        if(listOfOwners.get(this.owner)
                .equals(new Integer(2))){
            return 50;
        }
        if(listOfOwners.get(this.owner)
                .equals(new Integer(3))){
            return 100;
        }
        return 200;
    }
    @Override
    public void free(){
        int a = (listOfOwners.get(this.owner).intValue() - 1);
        listOfOwners.replace(this.owner,new Integer(a));
        super.freee();
        
    }
    @Override
    public String toString(){
        return this.getName() +", Ower: "+this.owner.getName() + " tax rate " 
                + String.valueOf(this.calculateTax());
    }
    @Override
    public String getName() {
        return "RailRoad"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sell() {
        this.owner.getPersonAcc().changeAmount(this.purchaseCost);
        this.free();
    }

    @Override
    public void setMortaged() {
        super.setMortagedd();
    }
}
