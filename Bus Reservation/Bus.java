package model;

public class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;
    private String route;
    private int availabilty;

    public Bus(int no, boolean ac, int capacity, String route,int availability){
        this.busNo = no;
        this.ac = ac;
        this.capacity = capacity;
        this.route=route;
        this.availabilty= availability;
    }
    public String getRoute(){
        return route;
    }

    public int getBusNo(){
        return busNo;
    }

    public boolean isAc(){
        return ac;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getAvailabilty(){
        return availabilty--;
    }

    public void setAc(boolean val) {
        ac = val;
    }

    public void setCapacity(int capacity) {
        capacity = capacity;
    }
    public void setRoute(String route){
        route = route;
    }
}
