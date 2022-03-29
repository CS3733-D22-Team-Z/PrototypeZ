package edu.wpi.teamname;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ControlCSV {
	private File path;

	public ControlCSV(File active){
		path = active;
	}

	public final void writeCSV(List<List<String>> data, String... headers){
		String fLine = String.join(",", headers);
		FileWriter file = null;
		try {
			file = new FileWriter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			file.write(fLine + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int n = data.get(0).size();

		for (List<String> a:data) {

			String line = String.join(",", a);

			line+="\n";

			try {
				file.write(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public final List<List<String>> readCSV(){
		Scanner in = null;
		try {
			in = new Scanner(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line;
		List<List<String>> ret = new ArrayList<>();
		int c = 0;

		while ((line = in.nextLine()) != null){
			String [] temp = line.split(",");
			ret.add(List.of(temp));

		}
		return ret;
	}

	public abstract void dataToObj();
	public abstract List<List<String>> objToData(Object [] list);

}
