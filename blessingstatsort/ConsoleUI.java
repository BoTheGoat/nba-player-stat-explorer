/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blessingstatsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 1zomb
 */
public class ConsoleUI {
    Scanner userInput = new Scanner(System.in);
    int userChoice;
    List<Player> nbaPlayers = new ArrayList<>();
    String input;

    public ConsoleUI(List<Player> players){
      this.nbaPlayers = players;
    }
        
    // Call for the consoleUI. 
    
    public void start(){
       int userChoice;
       
       do {
           userChoice = displayMenu();
           startMenu(userChoice);
           
       } while(userChoice != 5);
       
    }
     
    
    // Loop for the menu
        
    private void startMenu(int userChoice){
        switch(userChoice){
            case 1:
                System.out.println("\n--- Points Per Game (PPG) ---");

                for (int i = 0; i < nbaPlayers.size(); i++) {
                 Player p = nbaPlayers.get(i);
                     System.out.printf("%2d. %-20s : %.1f%n", i + 1, p.getName(), p.getPoints());
                     
    }
                System.out.println("Would you like to sort the list in descending order");
                input = userInput.next().toLowerCase();
                if(input.equals("yes")){
                 sortRequest(nbaPlayers,"points");
                }
                break;
        
        case 2:
             System.out.println("\n--- Assists Per Game (APG) ---");
             
            for (int i = 0; i < nbaPlayers.size(); i++){
                  Player p = nbaPlayers.get(i);
                     System.out.printf("%2d. %-20s : %.1f%n", i + 1, p.getName(), p.getAssists());
                }
            System.out.println("Would you like to sort the list in descending order");
                input = userInput.next().toLowerCase();
                
                
                if(input.equals("yes")){
               sortRequest(nbaPlayers,"assists");
                }
              
            break;
        case 3:
                 System.out.println("\n--- Rebounds Per Game (RPG) ---");
            for (int i = 0; i < nbaPlayers.size(); i++){
                    Player p = nbaPlayers.get(i);
                     System.out.printf("%2d. %-20s : %.1f%n", i + 1, p.getName(), p.getRebounds());
                }
                System.out.println("Would you like to sort the list in descending order");
                input = userInput.next().toLowerCase();
        
                
                
                if(input.equals("yes")){
               sortRequest(nbaPlayers,"rebounds");
                }
            break;
        case 4:

            System.out.println("What stat would you like to filter?");
            String stat = userInput.next().toLowerCase();
            System.out.println("What threshold would you like to look at?");
            double threshold = userInput.nextDouble();
            
             List<Player> filtered = filterStats(threshold,stat);
            
            for (int i = 0; i < filtered.size(); i++){
                System.out.println(filtered.get(i).getName() + " " + getStatValue(filtered.get(i),stat));
            }
            System.out.println("Would you like to sort the filtered list? (yes/no)");
             String sortChoice = userInput.next().toLowerCase();

            if (sortChoice.equals("yes")) {
                 sortRequest(filtered, stat); // This will sort AND print the sorted list
    }
  
            break;
            
      
            
        case 5:
            System.out.println("Now exiting menu");
            break;
            
        

        default:
            System.out.println("Invalid option");
            break;
        }
        
    }
    // shows menu

    private int displayMenu(){
        System.out.println("\n=== Player Stats Menu ===");
        System.out.println("Please make a selection:");
        System.out.println("-------------------------");
        System.out.println("1) Show Points Per Game (PPG)");
        System.out.println("2) Show Assists Per Game (APG)");
        System.out.println("3) Show Rebounds Per Game (RPG)");
        System.out.println("4) Filter players by stat threshold");
        System.out.println("5) Exit menu");
        System.out.println("-------------------------");
        System.out.print("Enter your choice: ");
                
        return userInput.nextInt();
        
    }
    
    //Shows stats that have been filtered to a certain threshold
    
    private List<Player> filterStats(double threshold, String stat){
      stat = stat.toLowerCase();
        
        List<Player> filteredPlayers = new ArrayList<>();        
        if(stat.equals("points")){
            for(int i = 0; i < nbaPlayers.size(); i++){
                if(nbaPlayers.get(i).getPoints() >= threshold)
                   filteredPlayers.add(nbaPlayers.get(i));
            }
        }
        else if(stat.equals("rebounds")){
            for(int i = 0; i < nbaPlayers.size(); i++){
                if(nbaPlayers.get(i).getRebounds() >= threshold)
                   filteredPlayers.add(nbaPlayers.get(i));
            }
            
        }
        else if(stat.equals("assists")){
            for(int i = 0; i < nbaPlayers.size(); i++){
                if(nbaPlayers.get(i).getAssists() >= threshold)
                   filteredPlayers.add(nbaPlayers.get(i));
            }
        
        }
        return filteredPlayers;
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
     
     private void sortRequest (List<Player> players, String stat){
  
             sortPlayer mergeSort = new sortPlayer();
             
            List<Player> sorted = mergeSort.mergeSort(players, stat);
         
            
              for (int i = 0; i < sorted.size(); i++){
               System.out.printf("%2d. %-20s : %.1f%n", i + 1, sorted.get(i).getName(), getStatValue(sorted.get(i), stat));
              }
         
         
         
     }
        
   
    
        
    }
    

