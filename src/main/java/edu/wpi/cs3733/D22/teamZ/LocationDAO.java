package edu.wpi.cs3733.D22.teamZ;

import java.util.*;

public class LocationDAO implements ILocationDAO{

    ArrayList <Location> locations = new ArrayList<Location>();
    public List<Location> getAllLocations(){
        List l = new ArrayList();
        return l;
    }
    public Location getLocation(String nodeID){
        return new Location();
    }
    public void addLocation(Location loc){
        locations.add(loc);
    }
    public void updateLocation(Location loc){
        locations.remove(loc);
        locations.add(loc);
    }
    public void deleteLocation(Location loc){
        locations.remove(loc);
    }
}
