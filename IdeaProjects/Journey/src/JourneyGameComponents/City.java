package JourneyGameComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by omar on 11/10/14.
 */
public class City {
    int xCoordinate;
    int yCoordinate;
    String color;
    String name;
    int quarter;
    ArrayList<String> neighboringCityNames = new ArrayList<String>();
    ArrayList<String> seaNeighbours = new ArrayList<String>();
    boolean occupied;
    boolean isSeaPort;
    boolean isAirPort;
    boolean hasRules;
    Player occupiedByPlayer;


    public Player getOccupiedByPlayer() {
        return occupiedByPlayer;
    }

    public void setOccupiedByPlayer(Player occupiedByPlayer) {
        this.occupiedByPlayer = occupiedByPlayer;
    }


    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    //public ArrayList<City> getNeighboringCities() {
        //return neighboringCities;
    //
    //}

    public ArrayList<String> getNeighboringCityNames(){
        return this.neighboringCityNames;
    }

    public void setNeighboringCities() throws FileNotFoundException {
        ArrayList<String> arrayList = new ArrayList<String>();
        File f = new File("bro.txt");
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            arrayList.add(s.nextLine());
        }
        String temp = "";
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).contains("City name: ")){
                temp = arrayList.get(i).substring(arrayList.get(i).indexOf(":") + 2);
            }
            else if(arrayList.get(i).contains("Land neighbour: ")){
                if(this.getName().equals(temp)){
                    neighboringCityNames.add(arrayList.get(i).substring(arrayList.get(i).indexOf(":") + 2));

                }
            }
            else if(arrayList.get(i).contains("Sea neighbour: ")){
                if(this.getName().equals(temp)){
                    seaNeighbours.add(arrayList.get(i).substring(arrayList.get(i).indexOf(":") + 2));
                }
            }

        }

    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isSeaPort() {
        return isSeaPort;
    }

    public void setSeaPort(boolean isSeaPort) {
        this.isSeaPort = isSeaPort;
    }

    public boolean isAirPort() {
        return isAirPort;
    }

    public void setAirPort(boolean isAirPort) {
        this.isAirPort = isAirPort;
    }

    public boolean isHasRules() {
        return hasRules;
    }

    public void setHasRules(boolean hasRules) {
        this.hasRules = hasRules;
    }





    public City(){}
    public City(int xCoordinate, int yCoordinate, String color, String name, int quarter){
        this.color = color;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.name = name;
        this.quarter = quarter;
    }


}
