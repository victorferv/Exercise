package PackageDomain;

import java.util.Scanner;
import javax.swing.JFileChooser;

public class Main {
	
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		JFileChooser fileChooser = new JFileChooser();
		String linkIn = null;
		String action = "start";
		try {
			fileChooser.setDialogTitle("Select the JSON file that you want to read");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.showOpenDialog(fileChooser);
			linkIn = fileChooser.getSelectedFile().getAbsolutePath();
		}
		catch (NullPointerException e) {
			System.out.println("***getMessage:" + e.getMessage());
			System.out.println("You don't select any file");
		}
		Positions pos = new Positions(linkIn);
		System.out.println("This tool allows read a JSON file and modify their propieties");
		System.out.println("Usage manual:");
		System.out.println("Type 'serial number' to modify the serial number of the position that you want from the JSON");
		System.out.println("Type 'initial time' to mcodify the initial time of the positions");
		System.out.println("Type 'initial time interval' to modify the initial time and the interval between times");
		System.out.println("Type 'export' to save the JSON in a new file");
		System.out.println("Type 'exit' to finish the execution and save the JSON in the same file");
		boolean active = true;
		while (active) {
			action = in.nextLine();
			if (action.equalsIgnoreCase("serial number")) {
				System.out.println("Which position do you want to change?");
				int i = Integer.parseInt(in.nextLine());
				System.out.println("Introduce the new serial number:");
				String serial = in.nextLine();
				pos.modifySerialNumber(i, serial);
				System.out.println("Serial number successfully modified");
			}
			else if (action.equalsIgnoreCase("initial time")) {
				System.out.println("Introduce the new initial time:");
				long time = Long.parseLong(in.nextLine());
				pos.modifyTime(time);
				System.out.println("Time successfully modified");
			}
			else if (action.equalsIgnoreCase("initial time interval")) {
				System.out.println("Introduce the new initial time:");
				long time = Long.parseLong(in.nextLine());
				System.out.println("Introduce the new interval:");
				long interval = Long.parseLong(in.nextLine());
				pos.modifyTimeAndInterval(time, interval);;
				System.out.println("Time successfully modified");
			}
			else if (action.equalsIgnoreCase("export")) {
				try {
					String linkOut;
					fileChooser.setDialogTitle("Select the directory where you want to generate the JSON file");
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fileChooser.showOpenDialog(fileChooser);
					linkOut = fileChooser.getSelectedFile().getAbsolutePath();
					System.out.println("Introduce the name of the new file:");
					String name = in.nextLine();
					pos.export(linkOut + "/" + name);
					System.out.println("File successfully created");
				}
				catch (NullPointerException e) {
					System.out.println("***getMessage:" + e.getMessage());
					System.out.println("You don't select any file");
				}
			}
			else if (action.equalsIgnoreCase("exit")) {
				pos.export(linkIn);
				active = false;
			}
		}
		in.close();
	}

}
