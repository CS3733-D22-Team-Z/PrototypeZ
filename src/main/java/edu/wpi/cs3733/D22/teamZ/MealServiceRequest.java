package edu.wpi.cs3733.D22.teamZ;

public class MealServiceRequest {
    private String patientName;
    private int patientID;
    private String roomNumber;
    private String mealServiceOption;
    private String staffAssigned;
    private String problemDescription;

    public MealServiceRequest(){}

    public MealServiceRequest(
            String patientName,
            int patientID,
            String roomNumber,
            String mealServiceOption,
            String staffAssigned,
            String problemDescription){
        this.patientName = patientName;
        this.patientID = patientID;
        this.roomNumber = roomNumber;
        this.mealServiceOption = mealServiceOption;
        this.staffAssigned = staffAssigned;
        this.problemDescription = problemDescription;
    }

    //GetterFunctions
    public String getPatientName(){return this.patientName;}
    public int getPatientID(){return this.patientID;}
    public String getRoomNumber(){return this.roomNumber;}
    public String getMealServiceOption(){return this.mealServiceOption;}
    public String getStaffAssigned(){return this.staffAssigned;}
    public String getProblemDescription(){return this.problemDescription;}

    //SetterFunction
    public void setPatientName(String patientName){this.patientName = patientName;}
    public void setPatientID(int patientID){this.patientID = patientID;}
    public void setRoomNumber(String roomNumber){this.roomNumber = roomNumber;}
    public void setMealServiceOption(String mealServiceOption){this.mealServiceOption = mealServiceOption;}
    public void setStaffAssigned(String staffAssigned){this.staffAssigned = staffAssigned;}
    public void setProblemDescription(String problemDescription){this.problemDescription = problemDescription;}
}
