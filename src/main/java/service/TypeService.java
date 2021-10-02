package service;

import convert.ConvertType;
import dao.TypeDao;
import dto.MovieDTO;
import dto.TypeDTO;
import entities.Type;
import utils.Contants;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

public class TypeService {
    private ConvertType convertType = new ConvertType();
    private Type type = new Type();
    private TypeDao typeDao = new TypeDao();

    /**
     * validator type object and call typeDao
     *
     * @param typeDTO
     * @return 1 if save success , otherwise 0
     */
    public String saveTypeService(TypeDTO typeDTO) throws Exception{
        int statusSaveType = 0;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        type = convertType.convertToModel(typeDTO);
        Set<ConstraintViolation<Type>> constraintViolations = validator.validate(type);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Type> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            Date date = new Date();
            type.setCreatedDate(date);
            type.setIsActive("Y");
            statusSaveType = typeDao.save(type);
        }
        if (statusSaveType == 1) {
            return Contants.SUCCESS;
        } else {
            return Contants.FAIL;
        }
    }


    /**
     * validator type object and check if status equal u then call update , otherwise class delete
     *
     * @param typeDTO
     * @param status
     * @return status change type
     */
    public int changeType(TypeDTO typeDTO , String status) {
        int statusChange = 0;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        type = convertType.convertToModel(typeDTO);
        Set<ConstraintViolation<Type>> constraintViolations = validator.validate(type);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Type> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            if ("U".equals(status)) {
                typeDao.update(type);
            } else {
                typeDao.delete(type);
            }
        }
        return statusChange;
    }
}
