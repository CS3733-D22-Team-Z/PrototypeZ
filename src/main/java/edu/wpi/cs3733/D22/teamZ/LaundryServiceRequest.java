package edu.wpi.cs3733.D22.teamZ;

public class LaundryServiceRequest {
    private String patientName;
    private int patientID;
    private String roomNumber;
    private String linenType;
    private String staffAssigned;
    private String problemDescription;

    public LaundryServiceRequest(){}

    public LaundryServiceRequest(
            String patientName,
            int patientID,
            String roomNumber,
            String linenType,
            String staffAssigned,
            String problemDescription){
        this.patientName = patientName;
        this.patientID = patientID;
        this.roomNumber = roomNumber;
        this.linenType = linenType;
        this.staffAssigned = staffAssigned;
        this.problemDescription = problemDescription;
    }

    //GetterFunctions
    public String getPatientName(){return this.patientName;}
    public int getPatientID(){return this.patientID;}
    public String getRoomNumber(){return this.roomNumber;}
    public String getLinenType(){return this.linenType;}
    public String getStaffAssigned(){return this.staffAssigned;}
    public String getProblemDescription(){return this.problemDescription;}

    //SetterFunctions
    public void setPatientName(String patientName){this.patientName = patientName;}
    public void setPatientID(int patientID){this.patientID = patientID;}
    public void setRoomNumber(String roomNumber){this.roomNumber = roomNumber;}
    public void setLinenType(String linenType){this.linenType = linenType;}
    public void setStaffAssigned(String staffAssigned){this.staffAssigned = staffAssigned;}
    public void setProblemDescription(String problemDescription){this.problemDescription = problemDescription;}
}
