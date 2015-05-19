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
		
		Student[][] classroom = generateChart(rows, cols, students);
		
		for (int r = 0; r < classroom[0].length; r++) {
			for (int c = 0; c < classroom.length; c++) {
				System.out.print(classroom[r][c].getName() + "     ");
			}
			System.out.println();
		}
		
		String again = JOptionPane.showInputDialog("Do you want to generate another seating chart? (Y/N)");
		String same = JOptionPane.showInputDialog("Using the same students? (Y/N)");
		
		if (again.equals("Y") && same.equals("Y")) {
			generateChartAgain(rows,cols,students, classroom);
		}

	}

	private static void generateChartAgain(int rows, int cols, ArrayList<Student> students, Student[][] classroom) {
		
	}

	private static Student[][] generateChart(int rows, int cols, ArrayList<Student> students) {
		int firstStudentIndex = (int)Math.random()*(students.size());
		Student firstStudent = students.get(firstStudentIndex);
		Student[][] classroom = new Student[rows][cols];
		int counter = 0; //what's the point of counter again
		classroom[0][0] = firstStudent; 
		Student previousStudent = firstStudent;
		while (counter < students.size() - 1) {
			for (int r = 0; r < rows; r++) {
				for (int c = 1; c < cols; c++) {	//[0][0] has already been set
					System.out.println("cool");
					
					if (r != 0) {
						//someone above 
						previousStudent = classroom[r-1][c];
						Student nextStudent = findNextStudent(previousStudent, students);
						if (c != 0) { //someone to the left as well
							Student left = classroom[r][c-1];
							while (!inArrayList(left, nextStudent, students)) {
								nextStudent = findNextStudent(previousStudent, students);
							}
							classroom[r][c] = nextStudent; //remove nextStudent from previousStudent's and left's arrayList
						}
					}		
					
					if (r == 0) {
						//below hasn't been initialized, it doesn't matter. only one that matters is to the left
						previousStudent = classroom[r][c-1];
						Student nextStudent = findNextStudent(previousStudent, students);
						classroom[r][c] = nextStudent; //remove nextStudent from previousStudent's arrayList
					}
					counter++;
				}
			}
		}
		return classroom;
	}
	

	private static boolean inArrayList(Student left, Student nextStudent, ArrayList<Student> students) {
		ArrayList<String> otherStudents = left.getPossibleStudents();
		for (Student s : students) {
			if (s.getName().equals(nextStudent)) {
				return true;
			}
		}
		return false;
	}

	private static Student findNextStudent(Student previousStudent, ArrayList<Student> students) {		//randomly generates student
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
