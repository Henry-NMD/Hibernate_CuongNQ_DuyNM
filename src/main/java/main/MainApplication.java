package main;

import dto.TypeDTO;
import file.ReadType;
import service.TypeService;
import utils.HibernateUtils;
import utils.Contants;

import java.util.Scanner;

public class MainApplication {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TypeDTO typeDTO = new TypeDTO();
        TypeService typeService = new TypeService();
        String chose = null;
        menu();
        while (true) {
            chose = scanner.nextLine().trim();
            switch (chose) {
                case Contants.SAVE_TYPE: {
                    String statusSave;
                    try {
                        typeDTO = ReadType.readExcel();
                        statusSave = typeService.saveTypeService(typeDTO);
                        System.out.println(statusSave);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case Contants.UPDATE_TYPE: {
                    String statusUpdate;
                    String update = "U";
                    try {
                        typeDTO = ReadType.readExcel();
                        typeService.changeType(typeDTO, update);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case Contants.DELETE_TYPE: {
                    String statusDelete;
                    String delete = "D";
                    try {
                        typeDTO = ReadType.readExcel();
                        typeDTO.setIsActive("N");
                        typeService.changeType(typeDTO, delete);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                default:
                    System.out.println("unknow: " + chose);
            }
            menu();
        }

    }

    public static void menu() {
        System.out.println("================Library===============");
        System.out.println("1. save a type");
        System.out.println("2. update a type");
        System.out.println("3. delete a type");
        System.out.println("4. find all type");
        System.out.println("4. save a movie");
        System.out.println("5. save a type_movie");
        System.out.println("your choose:");

    }

}
