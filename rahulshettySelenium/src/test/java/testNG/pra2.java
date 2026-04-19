package testNG;

import org.testng.annotations.Test;

public class pra2 {
	@Test 
	public void mobilelogin() {
		System.out.println("login");
	}
	@Test
	public void mobilelogout() {
		System.out.println("logout");
	}
	@Test (groups = {"smoke"})
	public void pc() {
		System.out.println("PC");
	}
}
