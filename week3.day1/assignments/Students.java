package week3.day1.assignment;

//create a class with same method overloaded
public class Students {

	public void getStudentInfo(int id)
	{
		System.out.println("1)\n id : "+id);
	}
	
	public void getStudentInfo(int id, String name)
	{
		System.out.println("2)\n id: "+id+"\nname : "+name);
	}
	
	public void getStudentInfo(String email, long phone)
	{
		System.out.println("3)\n email : "+email+"\nphone : +phone");
	}
	
	//instantiate class
	public static void main(String[] args) {

		Students sts= new Students();
		
		sts.getStudentInfo(1);
		sts.getStudentInfo(4, "Indhu");
		sts.getStudentInfo("indhu@gmail.com", 123456789);
	}

}
