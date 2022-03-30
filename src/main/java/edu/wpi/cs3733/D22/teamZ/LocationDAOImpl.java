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

  public Location getLocation(String nodeID) { // implement
    return new Location();
  }

  public void addLocation(Location loc) {
    locations.add(loc);
  }

  public void updateLocation(Location loc) {
    locations.remove(loc);
    locations.add(loc);
  }

  public void deleteLocation(Location loc) {
    locations.remove(loc);
  }
}
