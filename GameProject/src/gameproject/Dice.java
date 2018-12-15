/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import gameproject.allslot.Jail;
import gameproject.allslot.Slot;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author ThuyTrang
 */
public class Dice implements CanArrest{
    private static Hashtable<Player,Integer> Jail = new Hashtable<>(),Jail2;
    public static boolean send;
    private static Player prisoner = null;
    public static int h;
    public Dice(){
        Board theBoard = Board.getBoard();
        LinkedList list = theBoard.getPlayers();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Player i = (Player)it.next();
            Jail.put(i,new Integer(0));
        }
    }
    public static int rollAndGo(Player player){
        Dice d = new Dice();
        Jail2 = (Hashtable<Player, Integer>) Jail.clone();
        send = false;
        int a = (int) ((Math.random()*11) + 2);
        h = a;
        if(a == 12){
            Integer x = Jail.get(player),
                    w = new Integer((int)(x.intValue()+ 1));
            Jail.replace(player, w);
        }
        else{
            player.move(a);
        }
        return a;
    }
    private static boolean canSend(Player player){
        if(Jail.get(player).equals(new Integer(3))){
            send = true;
        }
        return send;
    }
    public static void sendToJail(Player player){
        //canSend(player);
        Slot g = null;
        for(Slot i:Board.getSlots()){
            if(i instanceof Jail){
               g = i; 
            }
        }
        if(send == true){
            //implement something
           player.move(g);//phải đổi thành jail
           Jail.replace(player, new Integer(0));
           Dice.prisoner = player;
           Dice.send = true;
           //phải có jail slot để receivePlayer
        }
    }
    public static void end(){
        send = false;
        Jail = Jail2;
    }

    @Override
    public Player getPrisoner() {
        return Dice.prisoner;
    }
    public static int roll(){
        return (int) (Math.random()*11 + 2);
    }
}
