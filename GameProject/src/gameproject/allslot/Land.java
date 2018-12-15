/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject.allslot;

import gameproject.Board;
import gameproject.Player;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
/**
 *
 * @author ThuyTrang
 */
public class Land extends Property{

    private String sector;
    private int numHouses = 0;
    private int numHotel = 0;
    public Land(String sector,String name,int purchaseCost,int tax) {
        this.purchaseCost = purchaseCost;
        this.tax = tax;
        this.sector = sector;
        this.name = name;
        helperClass.add(this);
    }
    public int getHouses(){
        return numHouses;
    }
    @Override
     public int calculateTax(){ 
         if(this.numHotel == 1){
             return (tax*13 + 100);
         }
         switch(this.numHouses){
             case 0:if(!hasMonopoly()){return tax/5;}else{return (tax/5)*2;}
             case 2:return tax*3;
             case 3:return tax*6;
             case 4:return tax*9;
         }
         return tax;
    }
    @Override
     public void free(){
         super.freee();
         this.numHouses = 0;
         this.numHotel = 0;
         ///
    }
    @Override
    public void buy(Player player){
        super.buyy(player);
    }
    @Override
    public String toString(){
        return "Land slot:" + name+" sector "+ this.sector + " tax rate "+ 
                String.valueOf(this.calculateTax()) + 
                " ,number of house "+ this.numHouses +
                ", number of hotel "+ this.numHotel +
                " ,owner " + this.owner.getName();
    }
    public void upgrade(){
        if(this.hasMonopoly()&&
          (this.owner.getPersonAcc().getAmount() >= purchaseCost)
           && owner.ask() && this.numHouses < 5 
           && helperClass.minHouse(owner, sector) == numHouses
           && this.numHotel == 0){
        this.owner.getPersonAcc().changeAmount(-purchaseCost);
        if(this.numHouses == 4){
            numHotel++;
        }
        else{
            numHouses++;
            numHouses = 0;
        }
        }
        System.out.println(this);
    }
    @Override
    public String getName(){
        return "Land slot "+ this.sector;
    }
    @Override
    public void sell(){
        this.owner.getPersonAcc().changeAmount(
                (int) (purchaseCost*((double)(1+0.5*this.numHouses))+
                purchaseCost*2.5*this.numHotel));
        this.free();
    }
    public boolean hasMonopoly(){
        //return true;// chạy thật sự thì xóa dòng và chạy dòng dưới
        return helperClass.hasMonopoly(owner, sector);
    }
    public String getSector(){
        return sector;
    }

    @Override
    public void setMortaged() {
       super.setMortagedd();
       this.owner.getPersonAcc().changeAmount(
               (int)0.5*this.numHouses*this.purchaseCost+
                (int)2.5*this.numHotel*this.purchaseCost);
       this.numHouses = 0;
    }
    public int getnumHotel(){
        return this.numHotel;
    }
}
class helperClass{
    static Hashtable<String,Integer> h = new Hashtable<>();
    public static void add(Land land){
        if(!h.containsKey(land.getSector())){
           h.put(land.getSector(),new Integer(1)); 
        }
        else{
            Integer a = h.get(land.getSector());
            h.replace(land.getSector(),new Integer(Integer.sum(a.intValue(), 1)));
        }
    }
    public static boolean hasMonopoly(Player player,String sector){
        ArrayList property = player.getPersonAcc().getProperties();
        int a = 0;
        for (Iterator iterator = property.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            if(next instanceof Land){
                Land i = (Land) next;
                if(i.getSector().equals(sector)){
                    a++;
                }
            }
        }
        return (h.get(sector).compareTo(new Integer(a)) == 0);
    }
    public static int minHouse(Player player,String sector){
        int a,b = 4;
        for (Iterator iterator = player.getPersonAcc().getProperties().iterator(); iterator.hasNext();) {
            Property next = (Property) iterator.next();
            if(next instanceof Land){
                if(((Land) next).getSector() == sector){
                    a = ((Land) next).getHouses();
                    if(((Land) next).getnumHotel() == 1){
                        a = 4;
                    }
                    a = Integer.min(a,b);
                    b = a;
                }
            }
        }
        return b;
    }
    /*public static boolean canUpgrade(){
        
    }*/
}
