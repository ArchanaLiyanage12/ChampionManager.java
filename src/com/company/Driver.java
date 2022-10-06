package com.company;

import java.io.Serializable;

abstract class Driver implements Serializable {
    private String drivername;
    private String location;
    private String team;

     public Driver(String drivername, String location, String team) {  // constructor
         this.drivername = drivername;
         this.location = location;
         this.team = team;
     }

     public Driver() {

     }
//getters and setters
     public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

