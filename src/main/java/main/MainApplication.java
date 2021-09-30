package main;

import utils.HibernateUtils;

public class MainApplication {

	public static void main(String[] args) {
		System.out.println("Running hibernate config");
		HibernateUtils.getSessionFactory();
		
	}

}
