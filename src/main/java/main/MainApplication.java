package main;

import dto.TypeDTO;
import file.ReadType;
import service.TypeService;
import utils.HibernateUtils;

public class MainApplication {

	public static void main(String[] args) {
		TypeService typeService = new TypeService();
		System.out.println("Running hibernate config");
		HibernateUtils.getSessionFactory();
		try {
			TypeDTO typeDTO = ReadType.readExcel();
			int a = typeService.saveTypeService(typeDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
