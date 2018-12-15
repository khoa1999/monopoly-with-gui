/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;
import gameproject.allslot.RailRoad;
import gameproject.allslot.Land;
import gameproject.allslot.Slot;
import gameproject.allslot.Jail;
import gameproject.allslot.*;
import java.util.LinkedList;
import java.io.*;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Iterator;
/**
 *
 * @author ThuyTrang
 */
public class GameProject {
    static Slot[] slots;
    static LinkedList<Player> a;
    private static Slot[][] Slot;
    private static Hashtable<Player,Integer> check;
    private static int h;
    private static boolean skipATurn = false;
    private static  int len = 40;
    public static void main(String[] args) throws Exception{
        // TODO code application logic her
        a = GameProject.getListPlayer();
        Board.setPlayers(a);
        slots = GameProject.createSlots();
        Board.setSlots(slots);        
        playTheGame();
        
    }
    public GameProject(){
        
    }
    public static int getNumPlayers(){
        // test number of player
        int a = 0;
        a = (int) (Math.random()*3);
        a = a+2;
        return a;

    }
    private static LinkedList<Player> getListPlayer() {
        // 
       
        LinkedList<Player> listPlayer = new LinkedList<Player>();
        int  i = 1,num = getNumPlayers();
        String[] name = new String[]{"Alpha","Beta","Charlie","Delta","Echo"};
        while(i <= num){
            listPlayer.add(new Player(name[i]));
            i++;
        }
        return listPlayer;
    }

    @SuppressWarnings("empty-statement")
    private static Slot[] createSlots() throws Exception{
        Slot[] slots = new Slot[len];
        int index = 0;
        String CurrentContent;

        // The name of the file to open.
        String fileName = "src\\gameproject\\input\\temp.txt";
        //System.out.println(Paths.get(".").toAbsolutePath().normalize().toString());
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);


            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            //Instanciate the slot để bắt đầu chơi
            //phải đổi index 
            while((line = bufferedReader.readLine()) != null && index < len) {
                CurrentContent = line;
                if(CurrentContent.contains("Land")){
                    Integer A = (new Integer(CurrentContent.split(" ")[2]));
                    int a = A.intValue();
                    String b = CurrentContent.split(" ")[1];
                    String f = CurrentContent.split(" ")[3];
                    int r= Integer.parseInt(CurrentContent.split(" ")[2]);
                    slots[index] = (Slot) new Land(b,f,a,r);
                }
                else if(CurrentContent.contains("RailRoad")){
                    slots[index] = (Slot) new RailRoad();
                }
                else if(CurrentContent.equalsIgnoreCase("Chance")){
                    slots[index] = (Slot) new Chance();
                }
                else if(CurrentContent.equalsIgnoreCase("Community")){
                    slots[index] = (Slot) new Community();
                }
                else if(CurrentContent.equalsIgnoreCase("Jail")){
                    slots[index] = (Slot) new Jail();
                }
                else if(CurrentContent.equalsIgnoreCase("GotoJail")){
                    slots[index] = (Slot) new GotoJail();
                }
                else if(CurrentContent.equalsIgnoreCase("Parking")){
                    slots[index] = (Slot) new Parking();
                }
                else if(CurrentContent.equalsIgnoreCase("Start")){
                    slots[index] = Start.getStart();
                }
                else if(CurrentContent.contains("Tax")){
                    int a = (new Integer(CurrentContent.split(" ")[1]))
                            .intValue();                    
                    slots[index] = (Slot) new Tax(a);              
                }
                else if(CurrentContent.equalsIgnoreCase("Electric") ||
                        CurrentContent.equalsIgnoreCase("Water")){
                    slots[index] = (Slot) new Utility(CurrentContent);
                }
                else{
                    throw new Exception();
                }
                index++;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
            ex.printStackTrace();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            ex.printStackTrace();
        }
        catch(Exception ex){
            int i = (index + 1);
            System.out.println(slots[index] == null);
            System.out.println("COI LẠI INPUT DÒNG "+ String.valueOf(i));
            //ex.printStackTrace();
        }
        return slots;
    }
    /*
    chơi trò chơi 
    */
    private static void playTheGame(){
        //index để ghi lại vị trí của mình trong game
        int index;
        //Player là linked list mình có thể iterate
        LinkedList<Player> Players = Board.getPlayers();
        //vòng lập mãi mãi
        index = 0;
        while(true){
            //kiểm tra có người chiến thắng bằng cách kiểm tra số lượng phần tử 
            if(Players.size() == 1){
                hasWinner(true);
                break;
            }
            try{
                //
                Player player = Players.get(index);
                Slot a = player.getCurrentPosition();
                GameProject.upgradeProperties(player);
                while(true){
                    a.toDOSomething(player);
                    if(GameProject.skipATurn){
                        skipATurn = false;
                        break;//invoke by the jail slot only
                    }
                    int v = Dice.rollAndGo(player);
                    Dice.sendToJail(player);
                    //int v = (int) (Math.random()*3) + 1;//testing code
                    //player.move(v);//testing
                    if(player.isBankrupted()){
                        Players.remove(player);
                        Board.setPlayers(Players);
                        index--;
                        System.out.print("Bye bye ");
                        System.out.println(player.getName());
                        break;
                    }
                    System.out.println(player);
                    if(Dice.send || v != 12){
                        Dice.end();
                        break;
                    }
                }
                index++;
            }
            catch(IndexOutOfBoundsException e){
                index = 0;
            }
        }
    }
    public static void hasWinner(boolean flag){
        //checks for winner and ends the game
        System.out.print("Winner: ");
        System.out.println(a.get(0).getName());
    }
    /*
    cộng tiền cho hoàn thành 1 vòng
    */
    public static void complete1Lap(Player player,int v){
        int a,length = len;
        if(check == null){
            check = new Hashtable<>();
            for(Iterator i=Board.getPlayers().iterator();i.hasNext();){
                check.put((Player) i.next(),new Integer(0));
            }
        }
        int b = check.get(player).compareTo(new Integer(length));
        if(!(Dice.send) && (b >= 0)){
            Integer w = new Integer(b + check.get(player).intValue()- length);
            player.getPersonAcc().changeAmount(200);
            check.replace(player, w);
            System.out.println(player.getName() + " gets 200");
        }
        else if(!Dice.send){
            if( (a = v+check.get(player).intValue()) >= 0){
                check.replace(player, new Integer(a));
            }  
            else{
                check.replace(player, new Integer(0));
            }
        }
            
    }
    public static void upgradeProperties(Player player){
       for (Iterator<Property> iterator = player.getPersonAcc().getProperties().iterator()
               ; iterator.hasNext();) {
            Property next = iterator.next();
            if(next instanceof Land){
                ((Land) next).upgrade();
            }
        }
    }
    public static void skip(Jail slot){
        GameProject.skipATurn = true;
    }
    public static void soldProperty(Player player){
        for (Iterator<Property> iterator = player.getPersonAcc().getProperties().iterator()
               ; iterator.hasNext();) {
            Property i = iterator.next();
            i.sell();
        }       
    }
            
}

