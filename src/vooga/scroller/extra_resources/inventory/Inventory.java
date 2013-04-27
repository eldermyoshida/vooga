package vooga.scroller.extra_resources.inventory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import games.scroller.mr_fish.sprites.player.MrFish;
import util.Location;
import util.input.InputClassTarget;
import vooga.scroller.level_management.IInputListener;
import vooga.scroller.statistics.Statistic;

@InputClassTarget
public class Inventory implements Statistic{

    private static final String NAME = "INVENTORY";
    
    private static final int COLUMNS = 10;
    
    private static final int MARGIN = 100;
    
    private static final int ROWS = 10;
    
    private static final Dimension BOX_SIZE = new Dimension(64,64);
    
    private static final Color SELECTION_COLOR = Color.red;
    

    
    private List<Item> myItems;
    private int myMoney;
    
    private int mySelection;

    private MrFish myFish;
    
    public Inventory(MrFish fish){
        myItems = new ArrayList<Item>();
        mySelection = 0;
        myFish = fish;
    }
    
    @Override
    public void addValue (int val) {
        myMoney += val;
    }

    @Override
    public void removeValue (int val) {
        myMoney -= val;

    }

    @Override
    public int getAggregateValue () {
        // TODO Auto-generated method stub
        return myMoney;
    }

    @Override
    public String getName () {
        // TODO Auto-generated method stub
        return NAME;
    }
    
    public void addItem(Item item){
        myItems.add(item);
    }
    
    public void paint(Graphics2D pen) {
        Iterator<Item> it = myItems.iterator();
        int row = 0;
        int column = 0;
        int count = 0;
       for(Item item: myItems){
           
           Location local = new Location(column*BOX_SIZE.width + MARGIN, row*BOX_SIZE.height + MARGIN);
           
           item.getView().paint(pen, local, BOX_SIZE);
           
           if(count == mySelection-1 || (mySelection == 0 && (count == myItems.size()-1))){
               Rectangle r = new Rectangle(BOX_SIZE);
               r.setLocation((int)local.x - BOX_SIZE.width/2, (int)local.y - BOX_SIZE.height/2);
               pen.setColor(SELECTION_COLOR);
               pen.draw(r);
           }
           
           if(column < COLUMNS -1){
               column = column + 1;
           }
           else{
               column = 0;
               row = row + 1;
           }
           count +=1;
       }
            
        
    }

    public void getNextItem () {
        mySelection +=1;
        if(mySelection >= myItems.size()){
            mySelection = 0;
        }
        
    }

    public void getPreviousItem () {
        mySelection -=1;
        if(mySelection < 0){
            mySelection = myItems.size()-1;
        }
    }

    public void selectCurrent () {
        Item selection = myItems.get(mySelection);
        myItems.remove(mySelection);

        
        selection.useItem(myFish);
        System.out.println(selection);
        
        
        if(mySelection == myItems.size()-1){
            mySelection = 0;
        }
        
    }


}
