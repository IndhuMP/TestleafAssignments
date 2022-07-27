package week3.day1.assignment;

//implement the interfaces and the abstract class
public class Automation extends MultipleLanguage{

	public void Java() {
		System.out.println("Language used is JAVA.");
		
	}

	public void Selenium() {
		System.out.println("Testing tool used is Selenium.");
		
	}

	@Override
	public void ruby() {
		System.out.println("Language is Ruby.");
		
	}
	
	//instantiate the class
	public static void main(String[] args) {
		Automation auto = new Automation();
		
		auto.Java();
		auto.Selenium();
		auto.python();
		auto.ruby();
	}

}
