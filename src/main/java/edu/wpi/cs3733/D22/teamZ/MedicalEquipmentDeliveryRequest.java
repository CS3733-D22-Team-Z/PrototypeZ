package edu.wpi.cs3733.D22.teamZ;

public class MedicalEquipmentDeliveryRequest {
    private String roomNumber;
    private String equipment;
    private String staffAssigned;
    private String problemDescription;

    public MedicalEquipmentDeliveryRequest(){}

    public MedicalEquipmentDeliveryRequest(
            String roomNumber,
            String equipment,
            String staffAssigned,
            String problemDescription){
        this.roomNumber = roomNumber;
        this.equipment = equipment;
        this.staffAssigned = staffAssigned;
        this.problemDescription = problemDescription;
    }

    //GetterFunction
    public String getRoomNumber(){return this.roomNumber;}
    public String getEquipment(){return this.equipment;}
    public String getStaffAssigned(){return this.staffAssigned;}
    public String getProblemDescription(){return this.problemDescription;}

    //SetterFunction
    public void setRoomNumber(String roomNumber){this.roomNumber = roomNumber;}
    public void setEquipment(String equipment){this.equipment = equipment;}
    public void setStaffAssigned(String staffAssigned){this.staffAssigned = staffAssigned;}
    public void setProblemDescription(String problemDescription){this.problemDescription = problemDescription;}
}
