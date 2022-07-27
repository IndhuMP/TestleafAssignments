package week3.day1.assignment;

//create an abstract class
public abstract class MultipleLanguage implements Language, TestTool{
	
	public void python()
	{
		System.out.println("Python language");
	}
	
	public abstract void ruby();
}
