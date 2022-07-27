package org.department;

public class Student extends Department {
	
	public String studentName()
	{
		return "Indhu";
	}

	public String studentDept()
	{
		return deptName();
	}
	
	public int studentId()
	{
		return 105;
	}

	public static void main(String[] args) {
		
		Student st = new Student();
		
		System.out.println(st.collegeCode());
		System.out.println(st.collegeName());
		System.out.println(st.collegeRank());
		
		System.out.println(st.studentName());
		System.out.println(st.studentDept());
		System.out.println(st.studentId());
		
		
	}

}
