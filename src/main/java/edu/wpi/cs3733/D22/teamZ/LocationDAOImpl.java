package edu.wpi.cs3733.D22.teamZ;

import java.sql.*;
import java.util.*;

public class LocationDAOImpl implements ILocationDAO {

    List<Location> locations;

    public LocationDAOImpl() {
        locations = new ArrayList<>();
    }

    public List<Location> getAllLocations() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement pstmt = connection.prepareStatement("Select * From Location");
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                String nodeID = rset.getString("nodeID");
                int xcoord = rset.getInt("xcoord");
                int ycoord = rset.getInt("ycoord");
                String floor = rset.getString("floor");
                String building = rset.getString("building");
                String nodeType = rset.getString("nodeType");
                String longName = rset.getString("longName");
                String shortName = rset.getString("shortName");
                Location loc =
                        new Location(nodeID, xcoord, ycoord, floor, building, nodeType, longName, shortName);
                if (!locations.contains(loc)) {
                    locations.add(loc);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to get all Locations");
        }
        return locations;
    }

    public Location getLocationByID(String nodeID) { // implement
        Connection connection = null;
        Location loc = new Location();
        try {
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement pstmt =
                    connection.prepareStatement("Select * From LOCATION WHERE NODEID = ?");
            pstmt.setString(1, nodeID);
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
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
        } catch (SQLException e) {
            System.out.println("Unable to find location");
        }
        return loc;
    }

  public void addLocation(Location loc) {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:derby:myDB");
      PreparedStatement stmt =
          connection.prepareStatement(
              "INSERT INTO Location (NODEID, XCOORD, YCOORD, FLOOR, BUILDING, NODETYPE, LONGNAME, SHORTNAME)" +
                      "values (?, ?, ?, ?, ?, ?, ?, ?)");
      stmt.setString(1, loc.getNodeID());
      stmt.setInt(2, loc.getXcoord());
      stmt.setInt(3, loc.getYcoord());
      stmt.setString(4, loc.getFloor());
      stmt.setString(5, loc.getBuilding());
      stmt.setString(6, loc.getNodeType());
      stmt.setString(7, loc.getLongName());
      stmt.setString(8, loc.getShortName());

            stmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Statement failed");
        }
        locations.add(loc);
    }

    public void updateLocation(Location loc) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement stmt =
                    connection.prepareStatement("UPDATE Location SET floor=?, nodeTYPE =? WHERE nodeID =?");
            stmt.setString(1, loc.getFloor());
            stmt.setString(2, loc.getNodeType());
            stmt.setString(3, loc.getNodeID());

            stmt.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Statement failed");
        }
        locations.remove(loc);
        locations.add(loc);
    }

    public void deleteLocation(Location loc) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement stmt3 = connection.prepareStatement("DELETE FROM Location WHERE Nodeid=?");
            stmt3.setString(1, loc.getNodeID());
            stmt3.execute();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Statement failed");
        }
        locations.remove(loc);
    }
}
