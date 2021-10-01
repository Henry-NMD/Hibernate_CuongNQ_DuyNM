package main;

import dto.TypeDTO;
import file.ReadType;
import utils.HibernateUtils;

public class MainApplication {

	public static void main(String[] args) {
		System.out.println("Running hibernate config");
//		HibernateUtils.getSessionFactory();
		try {
			TypeDTO typeDTO = ReadType.readExcel();
			System.out.println(typeDTO.getTypeId());;
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
