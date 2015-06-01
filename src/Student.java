import java.util.ArrayList;

public class Student {
	
	ArrayList<String> studentListWithRemoval;
	ArrayList<String> studentListWithout;
	
	String name;

	public Student(String name, ArrayList<String> inputList) {
		ArrayList<String> temp = new ArrayList<String>();
		for (String s : inputList) {
			temp.add(s);
		}

		temp.remove(name);
		studentListWithRemoval = temp;
		studentListWithout = temp;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getPossibleStudents() {
		return studentListWithRemoval;
	}
	
	public ArrayList<String> getPossibleStudents1() {
		return studentListWithout;
	}
	
	public String toString() {
		return name;
	}
	
	public void removeStudent(String student) {
		studentListWithRemoval.remove(student);
	}
	
	public void removeStudentFromWithout(String student) {
		studentListWithout.remove(student);
	}

	
	public void setEqualArrays() {
		for (int i = 0; i < studentListWithRemoval.size(); i++) {
			studentListWithRemoval.remove(i);
		}
		for (int i = 0; i < studentListWithout.size(); i++) {
			studentListWithRemoval.add(studentListWithout.get(i));
		}
	}
}
