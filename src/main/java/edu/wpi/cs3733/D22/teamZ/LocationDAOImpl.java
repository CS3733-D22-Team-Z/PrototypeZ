package edu.wpi.cs3733.D22.teamZ;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

public class LocationDAOImpl implements ILocationDAO{

    List <Location> locations;

    public LocationDAOImpl(){
        locations = new ArrayList<>();
    }

    public List<Location> getAllLocations(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement pstmt = connection.prepareStatement("Select * From Location");
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()){
                String nodeID = rset.getString("nodeID");
                int xcoord = rset.getInt("xcoord");
                int ycoord = rset.getInt("ycoord");
                String floor = rset.getString("floor");
                String building = rset.getString("building");
                String nodeType = rset.getString("nodeType");
                String longName = rset.getString("longName");
                String shortName = rset.getString("shortName");
                Location loc = new Location(nodeID, xcoord, ycoord, floor, building,nodeType,longName,shortName);
                if(!locations.contains(loc)){
                    locations.add(loc);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Failed to get all Locations");
        }
        return locations;
    }
    public Location getLocation(String nodeID){ //implement
        Connection connection = null;
        Location loc = new Location();
        try{
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement pstmt = connection.prepareStatement("Select * From LOCATION WHERE NODEID =" + nodeID);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()){
                int xcoord = rset.getInt("xcoord");
                int ycoord = rset.getInt("ycoord");
                String floor = rset.getString("floor");
                String building = rset.getString("building");
                String nodeType = rset.getString("nodeType");
                String longName = rset.getString("longName");
                String shortName = rset.getString("shortName");
                loc.setNodeID(nodeID);
                loc.setXcoord(xcoord);
                loc.setYcoord(ycoord);
                loc.setFloor(floor);
                loc.setBuilding(building);
                loc.setNodeType(nodeType);
                loc.setLongName(longName);
                loc.setShortName(shortName);
            }
        }catch (SQLException e){
            System.out.println("Unable to find location");
        }
        return loc;
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
