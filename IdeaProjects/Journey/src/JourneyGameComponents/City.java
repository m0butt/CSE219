package JourneyGameComponents;

import java.util.ArrayList;

/**
 * Created by omar on 11/10/14.
 */
public class City {
    int xCoordinate;
    int yCoordinate;
    String color;
    String name;
    int quarter;
    ArrayList<City> neighboringCities;
    boolean occupied;
    boolean isSeaPort;
    boolean isAirPort;
    boolean hasRules;

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

    public ArrayList<City> getNeighboringCities() {
        return neighboringCities;
    }

    public void setNeighboringCities(ArrayList<City> neighboringCities) {
        this.neighboringCities = neighboringCities;
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
