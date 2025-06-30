/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blessingstatsort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1zomb
 */
public class sortPlayer {
    
    
   public List<Player> mergeSort(List<Player> players, String stat){
       
       if (players.size() <= 1){
           return players;
       }
       
       int midpoint = players.size() / 2;
       
       
       // Wrapping the sublist with a new arraylist to protect the original list from any modifications
       List<Player> left = new ArrayList<>(players.subList(0,midpoint));
       List<Player> right = new ArrayList<>(players.subList(midpoint, players.size()));
       
       List<Player> sortedLeft = mergeSort(left,stat);
       List<Player> sortedRight = mergeSort(right,stat);
      
       
       
       return mergeHalves(sortedLeft, sortedRight,stat);
       
       
   }
   
    private double getStatValue(Player player, String stat){
        
        stat = stat.toLowerCase();
        
        if(stat.equals("points")){
            return player.getPoints();
        }
        else if(stat.equals("rebounds")){
            return player.getRebounds();
        }
        else if(stat.equals("assists")){
            return player.getAssists();
        }
        else if(stat.equals("pra")){
            return player.getPRA();
        }
        else {
        throw new IllegalArgumentException("Unknown stat: " + stat);
    }
    }
   
    private List<Player> mergeHalves(List<Player> sortedRight, List<Player> sortedLeft, String stat){
       
        List<Player> sortedResults = new ArrayList<>();
        
        
        int i = 0, j = 0;
        
        
        while( i < sortedLeft.size() && j < sortedRight.size()){
           
       
           double leftStats = getStatValue(sortedLeft.get(i), stat);
           double rightStats = getStatValue(sortedRight.get(j), stat);
           
           if(leftStats >= rightStats){
               
               sortedResults.add(sortedLeft.get(i));
               i++;
    }
           else {
          
              sortedResults.add(sortedRight.get(j));
              j++;
     
           }
           
    }
        
        // left overs
        for (int k = i; k < sortedLeft.size(); k++) {
            sortedResults.add(sortedLeft.get(k));
            }
        
            for (int k = j; k < sortedRight.size(); k++) {
         sortedResults.add(sortedRight.get(k));
            }

        
    return sortedResults;
    
   
    }
   
    
    
}


