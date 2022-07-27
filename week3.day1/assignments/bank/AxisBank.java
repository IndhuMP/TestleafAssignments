package week3.day1.assignment;

//create a class that extends bankinfo class
public class AxisBank extends BankInfo{
	
	//override the method from previous class
	public void deposit()
	{
		System.out.println("1. Fixed deposit\n2. Recurring deposit");
	}
	public static void main(String[] args) {

		//instantiate the axisbank class and call the methods
		AxisBank ab = new AxisBank();
		
		ab.saving();
		ab.fixed();
		
		//calling the overriden method
		ab.deposit();
	}

}
