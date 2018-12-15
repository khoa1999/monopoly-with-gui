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
import gameproject.Player;
import gameproject.CanArrest;
import gameproject.Dice;
import gameproject.GameProject;
import java.util.Iterator;
import java.util.LinkedList;

public class Jail implements Slot {

    private LinkedList<Player> inJail = new LinkedList<>();

    public void receivePrisoner(CanArrest sender){
        Player i = sender.getPrisoner();
        if(i != null ){
            inJail.add(i);
        }
    }
    @Override
    public void toDOSomething(Player player) {
        if(inJail.contains(player)){
            int a = Dice.roll();
            if(player.getPersonAcc().gotCard()){
                inJail.remove(player);
            }
            else if(a != 12){
                inJail.remove(player);
                GameProject.skip(this);
            }
            else{
                player.getPersonAcc().changeAmount(-50);
                GameProject.skip(this);
            }
        }
    }
    @Override
    public String getName(){
        return "Jail slot";
    }
    @Override 
    public String toString(){
        String a = "";
        for(Iterator i = inJail.iterator();i.hasNext();){
            Player e = (Player) i.next();
            a = e.getName() + " ";
        }
        return  "Player in Jail: " + a;
    }
}

