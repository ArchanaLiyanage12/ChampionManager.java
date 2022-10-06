package com.company;

import java.io.Serializable;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>, Serializable {
    private int numoffirstposition;
    private int numofsecondpositions;
    private int numofthirdpositions;
    private int points;
    private int races;





    public Formula1Driver(String drivername, String location, String team, int numoffirstposition, int numofsecondpositions, int numofthirdpositions, int points, int races) {
        super(drivername, location, team);
        this.numoffirstposition = numoffirstposition;
        this.numofsecondpositions = numofsecondpositions;
        this.numofthirdpositions = numofthirdpositions;
        this.points = points;
        this.races = races;
    }
// Create  getters ans setters for private variables

    public int getNumoffirstposition() {
        return numoffirstposition;
    }

    public void setNumoffirstposition(int numoffirstposition) {
        this.numoffirstposition += numoffirstposition;
    }

    public int getNumofsecondpositions() {
        return numofsecondpositions;
    }

    public void setNumofsecondpositions(int numofsecondpositions) {
        this.numofsecondpositions += numofsecondpositions;
    }

    public int getNumofthirdpositions() {
        return numofthirdpositions;
    }

    public void setNumofthirdpositions(int numofthirdpositions) {
        this.numofthirdpositions += numofthirdpositions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points += points;
    }

    public int getRaces() {
        return races;
    }

    public void setRaces(int races) {
        this.races += races;
    }

    @Override
    // overriding the compareTO method which inherited from comparable interface

    public int compareTo(Formula1Driver o) {

        if(this.numoffirstposition>o.numoffirstposition)
            return -1;

        if (this.points==o.points)
            return 0;
        else if (this.points>o.points)
            return -1;
        else {
            return 1;
        }
    }
}
