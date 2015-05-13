import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

//C:\\Users\\mmagal203\\Desktop\\names.txt

public class Tester {

	public static void main(String[] args) {
		ArrayList<String> studentList = new ArrayList<String>();
		String fileName = JOptionPane
				.showInputDialog("What is the file name of the students?");

		loadDataFromFile(fileName, studentList);

		//System.out.print(studentList.toString());
		
		ArrayList<Student> students = convertToStudents(studentList);
		
//		for (Student stu : students) {
//			System.out.println(stu.getName());
//		}

	}

	public static void loadDataFromFile(String fileName,
			ArrayList<String> studentList) {
		try {
			Scanner scanner = new Scanner(new FileReader(fileName));
			String line;
			line = scanner.nextLine();

			for (String name : line.split(",")) {
				studentList.add(name);
			}

			scanner.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static ArrayList<Student> convertToStudents(ArrayList<String> studentList) {
		ArrayList<Student> students = new ArrayList<Student>();
		for (String name : studentList) {
			students.add(new Student(name, studentList));
		}
		return students;
	}
	
	

}
