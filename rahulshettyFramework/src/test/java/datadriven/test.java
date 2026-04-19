package datadriven;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) throws Exception {
		dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("Add profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));

	}
}
