import java.util.ArrayList;



public class Student {
	
	//HashMap<String, ArrayList<String>> otherStudents;
	ArrayList<String> studentList;
	
	String name;

	public Student(String name, ArrayList<String> inputList) {
		ArrayList<String> temp = new ArrayList<String>();
		for (String s : inputList) {
			temp.add(s);
		}

		temp.remove(name);
		studentList = temp;
		this.name = name;
		
		//System.out.println(name + " " + studentList.toString());
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<String> getPossibleStudents() {
		return studentList;
	}
	
	public String toString() {
		return name;
	}
	
	public void removeStudent(String student) {
		studentList.remove(student);
	}

}
