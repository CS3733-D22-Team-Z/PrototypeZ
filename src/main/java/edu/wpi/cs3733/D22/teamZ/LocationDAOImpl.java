package edu.wpi.cs3733.D22.teamZ;

import java.sql.*;
import java.util.*;

public class LocationDAOImpl implements ILocationDAO {

  List<Location> locations;

  public LocationDAOImpl() {
    locations = new ArrayList<Location>();
  }

  public List<Location> getAllLocations() {
    return locations;
  }

  public Location getLocation(String nodeID) {
    return new Location();
  }

  public void addLocation(Location loc) {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:derby:myDB");
      PreparedStatement stmt =
              connection.prepareStatement("INSERT INTO Location (NODEID, XCOORD, YCOORD, FLOOR, BUILDING, NODETYPE, LONGNAME, SHORTNAME)");
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
