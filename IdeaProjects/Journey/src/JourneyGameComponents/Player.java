package JourneyGameComponents;

import java.util.ArrayList;

/**
 * Created by omar on 11/20/14.
 */
public class Player {
    private String name;
    private boolean isComputer;
    private boolean isHuman;
    private String color;

    public City getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(City homeCity) {
        this.homeCity = homeCity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<City> getDestinations() {
        return destinations;
    }

    public void setDestinations(ArrayList<City> destinations) {
        this.destinations = destinations;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public ArrayList<City> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<City> history) {
        this.history = history;
    }

    public boolean isDestination() {
        return isDestination;
    }

    public void setDestination(boolean isDestination) {
        this.isDestination = isDestination;
    }

    private City homeCity;
    private ArrayList<City> destinations = new ArrayList<City>();
    private int points;
    private boolean winner;
    private City currentCity;
    private ArrayList<City> history = new ArrayList<City>();
    private boolean isDestination;



    public Player(){

    }
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
    }

    public boolean checkDestination(City visitedCity){
        return destinations.contains(visitedCity);
    }

    public void makeMove (City newPosition){
        currentCity = newPosition;
        if(checkDestination(newPosition)){
            destinations.remove(newPosition);
        }
    }




}
