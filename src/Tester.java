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
		
		ArrayList<Student> students = convertToStudents(studentList);
		
		String numRows = JOptionPane.showInputDialog("How many rows do you want?");
		String numCols = JOptionPane.showInputDialog("How many columns do you want?");
		int rows = Integer.parseInt(numRows);
		int cols = Integer.parseInt(numCols);
		
		generateChart(rows, cols, students);

	}

	private static void generateChart(int rows, int cols, ArrayList<Student> students) {
		int firstStudentIndex = (int)Math.random()*(students.size());
		Student firstStudent = students.get(firstStudentIndex);
		Student[][] classroom = new Student[rows][cols];
		int counter = 0;
		classroom[0][0] = firstStudent; 
		Student previousStudent = firstStudent;
		while (counter < students.size() - 1) {
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					System.out.println("cool");
					Student nextStudent = findNextStudent(previousStudent, students);
					if (r != 0) {
						//someone above, need to double check they can sit next to them too
						//INCREMENT COUNTER SOMEWHERE
					}
					classroom[r][c] = nextStudent;
					previousStudent = nextStudent;
					counter++;
				}
			}
		}
	}

	private static Student findNextStudent(Student previousStudent, ArrayList<Student> students) {
		ArrayList<String> otherStudents = previousStudent.getPossibleStudents();
		String seatedNext = otherStudents.get((int)(Math.random()*otherStudents.size()));
		Student next = null;
		for (Student s : students) {
			if (s.getName().equals(seatedNext)) {
				next = s;
			}
		}
		return next;
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
