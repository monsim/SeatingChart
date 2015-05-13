import java.util.ArrayList;
import java.util.HashMap;


public class Student {
	
	HashMap<String, ArrayList<String>> otherStudents;
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
		
		System.out.println(name + " " + studentList.toString());
	}
	
	public String getName() {
		return this.name;
	}

}
