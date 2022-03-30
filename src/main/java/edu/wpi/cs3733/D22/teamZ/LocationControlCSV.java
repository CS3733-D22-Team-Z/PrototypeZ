package edu.wpi.cs3733.D22.teamZ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationControlCSV extends ControlCSV {
  private String[] headers = {
    "NodeID", "xcoord", "ycoord", "floor", "building", "nodeType", "longName", "shortName"
  };

  protected void writeLocCSV(List<Location> in) {
    writeCSV(objToData(in), headers);
  }

  protected List<Location> readLocCSV() throws IOException {
    return dataToObj(readCSV());
  }

  private List<Location> dataToObj(List<List<String>> data) {
    List<Location> ret = new ArrayList<>();
    for (List<String> a : data) {
      ret.add(
          new Location(
              a.get(0),
              Integer.parseInt(a.get(1)),
              Integer.parseInt(a.get(2)),
              a.get(3),
              a.get(4),
              a.get(5),
              a.get(6),
              a.get(7)));
    }
    return ret;
  }

  protected List<List<String>> objToData(List<Location> in) {
    List<List<String>> ret = new ArrayList<>();

    for (Location a : in) {
      List<String> entry =
          new ArrayList<>(
              List.of(
                  new String[] {
                    a.getNodeID(),
                    Integer.toString(a.getXcoord()),
                    Integer.toString(a.getYcoord()),
                    a.getFloor(),
                    a.getBuilding(),
                    a.getNodeType(),
                    a.getLongName(),
                    a.getShortName()
                  }));
      ret.add(entry);
    }
    return ret;
  }
}
