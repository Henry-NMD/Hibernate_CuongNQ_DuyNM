package service;

import convert.ConvertType;
import dto.TypeDTO;
import entities.Type;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class TypeService {
    private ConvertType convertType = new ConvertType();
    private Type type;

    /**
     *  validator typeDTO and call typeDao
     *
     * @param typeDTO
     * @return 1 if save success , otherwise 0
     */
    public int saveTypeService(TypeDTO typeDTO) {
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

        }
        return statusSaveType;
    }
}
