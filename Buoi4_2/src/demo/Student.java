package demo;

public class Student {
	// TT
	private String name;
	private String GPA;

	// Constructor
	public Student(String name, String gPA) {
		super();
		this.name = name;
		GPA = gPA;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGPA() {
		return GPA;
	}

	public void setGPA(String gPA) {
		GPA = gPA;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", GPA=" + GPA + "]";
	}

	public String an() {
		return "com";
	}

}
