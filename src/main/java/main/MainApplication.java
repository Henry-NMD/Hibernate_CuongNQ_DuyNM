package main;

import dto.MovieDTO;
import dto.TypeDTO;
import file.ReadMovie;
import file.ReadType;
import service.TypeService;
import utils.HibernateUtils;

public class MainApplication {

	public static void main(String[] args) {
		TypeService typeService = new TypeService();
		System.out.println("Running hibernate config");
//		HibernateUtils.getSessionFactory();
		try {
			MovieDTO movieDTO = ReadMovie.readExcel();
			System.out.println(movieDTO.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
