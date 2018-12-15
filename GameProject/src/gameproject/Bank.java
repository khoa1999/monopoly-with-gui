/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author ThuyTrang
 */
import gameproject.allslot.Property;
import java.util.ArrayList;
import java.util.Iterator;
import gameproject.allslot.Card;

public class Bank {

    private int TotalMoney;

    private ArrayList<Property> properties = new ArrayList<>();
    private Player player;
    private boolean hasGetOutofJailCard = false;
    
    public Bank(Player player){
        TotalMoney = 1500;
        properties = new ArrayList<Property>();
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }

    public boolean canPlay() {
        return hasMoney();
        
    }

    public boolean hasMoney() {
        if(TotalMoney >=0){
            return true;
        }
        return false;
    }
    private void askForMoney(int amount){
        //gui for this fork
        for(Iterator<Property> it = this.properties.iterator();
                it.hasNext()&&(this.TotalMoney < amount);){
            Property i = it.next();
            
        }
    }
    public void changeAmount(int amount) {
        TotalMoney += amount;//xóa và chạy thử dòng dưới
        /*
        if((TotalMoney  + amount) >= 0){
            TotalMoney += amount;
        }
        else{
            askForMoney(amount);
        }
        */
    }

    public void buyOrSell(Property property, boolean operation) {
        if(operation == true && !this.properties.contains(property)){
            this.changeAmount(-property.getCost());
            this.properties.add(property);
        }
        else if(operation == false || property.getOwner() == this.player){
            property.sell();
            this.properties.remove(property);
        }
    }

    public Player trade(Property property, Player secondPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getAmount() {
        return this.TotalMoney; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return "Money: " + this.getAmount() + " total properties " 
                + String.valueOf(this.properties.size());
    }
    public void setCard(Card a){
        this.hasGetOutofJailCard = true;
    }
    public boolean gotCard(){
        if(this.hasGetOutofJailCard == false){
            return false;
        }
        this.hasGetOutofJailCard = false;
        return true;
    }
    public void free(){
        for(Iterator i = this.properties.iterator();i.hasNext();){
            Property j = (Property) i.next();
            j.free();
        }
        this.properties.clear();
    }
}

