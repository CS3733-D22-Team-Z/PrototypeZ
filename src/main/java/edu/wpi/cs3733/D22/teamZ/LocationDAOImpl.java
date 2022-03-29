package edu.wpi.cs3733.D22.teamZ;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

public class LocationDAOImpl extends ControlCSV implements ILocationDAO{

    List <Location> locations;

    public LocationDAOImpl(){
        locations = new ArrayList<Location>();
    }

    @Override
    public void dataToObj(List<List<String>> data) {
        for (List<String> a:data) {
            locations.add(new Location(
                    a.get(0),
                    Integer.parseInt(a.get(1)),
                    Integer.parseInt(a.get(2)),
                    a.get(3),
                    a.get(4),
                    a.get(5),
                    a.get(6),
                    a.get(7)));
        }
    }

    @Override
    public List<List<String>> objToData() {
        List<List<String>> ret = new ArrayList<>();
        for (Location a:locations) {
            List<String> entry = new ArrayList<>(List.of(new String[]{
                    a.getNodeID(),
                    Integer.toString(a.getXcoord()),
                    Integer.toString(a.getYcoord()),
                    a.getFloor(),
                    a.getBuilding(),
                    a.getNodeType(),
                    a.getLongName(),
                    a.getShortName()
            }));
            ret.add(entry);
        }
        return ret;
    }

    public List<Location> getAllLocations(){
        return locations;
    }
    public Location getLocation(String nodeID){ //implement
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
