package edu.wpi.cs3733.D22.teamZ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedEquipReqDAOImpl implements IMedEquipReqDAO{
    private List<MedEquipReq> list;

    public MedEquipReqDAOImpl(){
        list = new ArrayList<>();
    }

    public List<MedEquipReq> getAllMedEquipReq(){
        Connection connection = null;
        try{
            //establish connection
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            PreparedStatement pstmt = connection.prepareStatement("Select * From MEDEQUIPREQ");
            ResultSet rset = pstmt.executeQuery();

            while (rset.next()){
                //get the result set
                String reqID = rset.getString("requestID");
                String status = rset.getString("status");
                String issuer = rset.getString("issuer");
                String handler = rset.getString("handler");
                String equipment = rset.getString("equipment");
                String currentLoc = rset.getString("currentLoc");
                String targetLoc = rset.getString("targetLoc");

                //make new temp to put into list
                MedEquipReq temp = new MedEquipReq(reqID, status, issuer, handler, equipment, currentLoc, targetLoc);

                //if not in the list already, add it
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }
        }catch(SQLException e){
            System.out.println("Unable to get all Medical Equipment Requests");
        }
        return list;
    }

    public MedEquipReq getMedEquipReqByID(String id){
        Connection connection = null;
        MedEquipReq temp = new MedEquipReq();

        try{
            //establish connection
            connection = DriverManager.getConnection("jdbc:derby:myDB");
            //query to get information of request by ID
            PreparedStatement pstmt =
                    connection.prepareStatement("Select * From MEDEQUIPREQ WHERE REQUESTID = ?");
            pstmt.setString(1, id);
            ResultSet rset = pstmt.executeQuery();

            while(rset.next()){
                //get the result set
                String reqID = rset.getString("requestID");
                String status = rset.getString("status");
                String issuer = rset.getString("issuer");
                String handler = rset.getString("handler");
                String equipment = rset.getString("equipment");
                String currentLoc = rset.getString("currentLoc");
                String targetLoc = rset.getString("targetLoc");

                temp.setRequestID(reqID);
                temp.setStatus(status);
                temp.setIssuer(issuer);
                temp.setHandler(handler);
                temp.setEquipment(equipment);
                temp.setCurrentLoc(currentLoc);
                temp.setTargetLoc(targetLoc);
            }
        }catch (SQLException e){
            System.out.println("Unable to find request with given ID");
        }
        return temp;
    }

    public void addMedEquipReq(MedEquipReq req){
        //TODO
    }

    public void updateMedEquipReq(MedEquipReq req){
        //TODO
    }
    public void deleteMedEquipReq(MedEquipReq req){
        //TODO
    }
}
