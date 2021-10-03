package main;

import dto.TypeDTO;
import entities.Type;
import file.ReadType;
import service.TypeService;
import utils.HibernateUtils;
import utils.Contants;

import java.util.Date;
import java.util.List;
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
                        Date saveDate = new Date();
                        typeDTO = ReadType.readExcel();
                        typeDTO.setCreatedDate(saveDate);
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
                        Date updateDate = new Date();
                        typeDTO = ReadType.readExcel();
                        typeDTO.setUpdateDate(updateDate);
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
                        Date deleteDate = new Date();
                        typeDTO = ReadType.readExcel();
                        typeDTO.setIsActive("N");
                        typeDTO.setUpdateDate(deleteDate);
                        typeService.changeType(typeDTO, delete);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case Contants.FIND_ALL_TYPE: {
                    String status = "getAll";
                    List<TypeDTO> typeDTOS = typeService.getAllType(status);
                    if (typeDTOS.isEmpty() || typeDTOS == null) {
                        System.out.println("null");
                    } else {
                        typeDTOS.stream().forEach((TypeDTO type) -> {
                            System.out.println(type.toString());
                        });
                    }
                    break;
                }
                default:
                    System.out.println("what do you means? " + chose);
            }
            menu();
        }

    }

    public static void menu() {
        System.out.println("================Library===============");
        System.out.println("1. save a type");
        System.out.println("2. update a type");
        System.out.println("3. delete a type");
        System.out.println("4. save a movie");
        System.out.println("5. save a type_movie");
        System.out.println("6. get all type");

        System.out.println("your choose:");

    }

}
