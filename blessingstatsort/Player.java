/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blessingstatsort;

/**
 *
 * @author 1zomb
 */
public class Player {
    String name;
    double Points;
    double Rebounds;
    double Assists;

    public Player(String name, double Points, double Rebounds, double Assists) {
        this.name = name;
        this.Points = Points;
        this.Rebounds = Rebounds;
        this.Assists = Assists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoints() {
        return Points;
    }

    public void setPoints(double Points) {
        this.Points = Points;
    }

    public double getRebounds() {
        return Rebounds;
    }

    public void setRebounds(double Rebounds) {
        this.Rebounds = Rebounds;
    }

    public double getAssists() {
        return Assists;
    }

    public void setAssists(double Assists) {
        this.Assists = Assists;
    }
    
    public double getPRA(){
        return Points+ Rebounds + Assists;
    }

}