/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blessingstatsort;

/**
 *
 * @author 1zomb
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class BlessingStatSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        List<Player> Players = new ArrayList<>(retrieveData());
        
        retrieveData();
       
       ConsoleUI ui = new ConsoleUI(Players);
        
       ui.start();
        
  
            
    }
    
    public static List<Player> retrieveData(){
       
        String statsFile = "C:\\Users\\1zomb\\OneDrive\\Documents\\2024-25.csv";
        List<Player> NBAPlayers = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(statsFile))){
            // read line to skip header of csv file 
           reader.readLine();
   
           // Create player objects from stats being read in
          while((line = reader.readLine()) != null){
              String [] values = line.split(",");
              
              String name = values[1];
              double points = Double.parseDouble(values[29]);
              double rebounds = Double.parseDouble(values[23]);
              double assists = Double.parseDouble(values[24]);
              
              Player nbaPlayer = new Player(name,points,rebounds,assists);
              NBAPlayers.add(nbaPlayer);

          }
          
          //System.out.println(NBAPlayers.get(0).getAssists());
         
        } catch(IOException e){
                System.out.println("File not found");
                }
      
        return NBAPlayers;
    }
   
}
