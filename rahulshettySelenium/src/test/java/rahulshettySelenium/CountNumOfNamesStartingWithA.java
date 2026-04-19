package rahulshettySelenium;

import java.util.ArrayList;

public class CountNumOfNamesStartingWithA {

	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		a.add("Pavan");
		a.add("Karan");
		a.add("Anand");
		a.add("Anshika");
		int count=0;
		for(int i=0; i<a.size(); i++) {
			String name=a.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
}
