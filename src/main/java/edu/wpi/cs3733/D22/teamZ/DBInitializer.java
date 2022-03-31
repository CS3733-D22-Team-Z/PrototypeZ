package edu.wpi.cs3733.D22.teamZ;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DBInitializer {
  private LocationControlCSV locCSV;
  private MedEqReqControlCSV medEqReqCSV;

  public DBInitializer() {
<<<<<<< HEAD
    File locData = new File(System.getProperty("user.dir") + "\\TowerLocations.csv");
    File medEquipReqData = new File(System.getProperty("user.dir") + "\\MedEquipReq.csv");
=======
    File locData =
        new File(
            System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + "TowerLocations.csv");
    File medEquipReqData =
        new File(
            System.getProperty("user.dir")
                + System.getProperty("file.separator")
                + "MedEquipReq.csv");
>>>>>>> 5129b7d9d9130cfef26fb5d60b18e973e24aa1e9
    locCSV = new LocationControlCSV(locData);
    medEqReqCSV = new MedEqReqControlCSV(medEquipReqData);
  }

  public boolean createTables() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:derby:myDB");
      Statement stmt = connection.createStatement();

      // if you drop tables, drop them in the order from last created to first created
      stmt.execute("DROP TABLE MEDEQUIPREQ");
      stmt.execute("DROP TABLE  LOCATION");

      // Now recreate in the opposite order
      stmt.execute(
          "CREATE TABLE Location ("
              + "nodeID VARCHAR(15),"
              + "xcoord INTEGER,"
              + "ycoord INTEGER ,"
              + "floor VARCHAR(10),"
              + "building VARCHAR(20),"
              + "nodeType VARCHAR(5),"
              + "longName VARCHAR(50),"
              + "shortName Varchar(50),"
              + "constraint LOCATION_PK Primary Key (nodeID))");
      stmt.execute(
          "CREATE TABLE MEDEQUIPREQ ("
              + "requestID VARCHAR(15),"
              + "status VARCHAR(20),"
              + "issuer VARCHAR(50),"
              + "handler VARCHAR(50),"
              + "equipment VARCHAR(50),"
              + "currentLoc VARCHAR(15),"
              + "targetLoc VARCHAR(15),"
              + "constraint MEDEQUIPREQ_PK PRIMARY KEY (requestID),"
              + "constraint statusVal check (status in ('Processing', 'Done', 'Blank')))");
    } catch (SQLException e) {
      System.out.println("Failed to drop and create tables");
      return false;
    }
    return true;
  }

  public boolean populateLocTable() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:derby:myDB");
      List<Location> tempLoc = locCSV.readLocCSV();

      for (Location info : tempLoc) {
        PreparedStatement pstmt =
            connection.prepareStatement(
                "INSERT INTO Location (nodeID, xcoord, ycoord, floor, building, nodeType, longName, shortName) values (?, ?, ?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, info.getNodeID());
        pstmt.setInt(2, info.getXcoord());
        pstmt.setInt(3, info.getYcoord());
        pstmt.setString(4, info.getFloor());
        pstmt.setString(5, info.getBuilding());
        pstmt.setString(6, info.getNodeType());
        pstmt.setString(7, info.getLongName());
        pstmt.setString(8, info.getShortName());

        // insert it
        pstmt.executeUpdate();
        connection.commit();
      }

    } catch (SQLException e) {
      System.out.println("Failed to populate tables");
      return false;
    } catch (IOException e) {
      System.out.println("Failed to read CSV");
      return false;
    }
    return true;
  }

  public boolean populateReqTable() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:derby:myDB");
      List<MedEquipReq> tempReq = medEqReqCSV.readMedReqCSV();

      for (MedEquipReq info : tempReq) {
        PreparedStatement pstmt =
            connection.prepareStatement(
                "INSERT INTO MEDEQUIPREQ (requestid, status, issuer, handler, equipment, currentloc, targetloc) "
                    + "values (?, ?, ?, ?, ?, ?, ?)");
        pstmt.setString(1, info.getRequestID());
        pstmt.setString(2, info.getStatus());
        pstmt.setString(3, info.getIssuer());
        pstmt.setString(4, info.getHandler());
        pstmt.setString(5, info.getEquipment());
        pstmt.setString(6, info.getCurrentLoc());
        pstmt.setString(7, info.getTargetLoc());

        // insert it
        pstmt.executeUpdate();
        connection.commit();
      }

    } catch (SQLException e) {
      System.out.println("Failed to populate tables");
      return false;
    } catch (IOException e) {
      System.out.println("Failed to read CSV");
      return false;
    }
    return true;
  }
}
