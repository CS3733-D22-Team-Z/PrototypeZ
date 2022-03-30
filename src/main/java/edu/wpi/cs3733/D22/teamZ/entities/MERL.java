package edu.wpi.cs3733.D22.teamZ.entities;

import edu.wpi.cs3733.D22.teamZ.MedEquipReq;
import edu.wpi.cs3733.D22.teamZ.MedEquipReqDAOImpl;
import java.util.List;

public class MERL {
  private List<MedEquipReq> requestsRaw;
  private MedEquipReqDAOImpl database;
  // Field values for detailed view of requests
  private String[] identifiers = {
    "ID", "Device", "Assignee", "Handler", "Status", "Current Location", "Target Location"
  };

  public MERL() {
    database = new MedEquipReqDAOImpl();
    loadRequests();
  }

  // Retrieve all requests currently in database
  public void loadRequests() {
    requestsRaw = database.getAllMedEquipReq();
  }

  // Get the most recently loaded requests
  public List<MedEquipReq> getCurrentRequests() {
    return requestsRaw;
  }

  // Get a MedEquipReq from ID
  public MedEquipReq getRequestFromID(String ReqID) {
    return database.getMedEquipReqByID(ReqID);
  }

  // Get list of identifiers
  public String[] getIdentifiers() {
    return identifiers;
  }
}
