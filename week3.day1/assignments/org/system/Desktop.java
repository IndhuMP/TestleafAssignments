package org.system;

//create desktop class that inherits computer class
public class Desktop extends Computer {
	
	//create a method for desktop class
	public String desktopSize()
	{
		return "15 inch";
	}

	public static void main(String[] args) {
		
		//create an object for desktop class
		Desktop desk = new Desktop();
		System.out.println(desk.computerModel());
		System.out.println(desk.desktopSize());
			
		
	}

}
