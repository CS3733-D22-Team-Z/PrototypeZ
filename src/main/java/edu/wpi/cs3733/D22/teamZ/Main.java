package edu.wpi.cs3733.D22.teamZ;

public class Main {

  public static void main(String[] args) {
    DBInitializer init = new DBInitializer();
    init.createTables();
    init.populateLocTable();
    init.populateReqTable();
    App.launch(App.class, args);
  }
}
