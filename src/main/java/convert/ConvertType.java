package convert;

import dto.TypeDTO;
import entities.Type;

public class ConvertType {

    /**
     * convert from typeDTO  to type
     *
     * @param typeDTO
     * @return type
     */
    public Type convertToModel(TypeDTO typeDTO) {
        Type type = new Type();
        type.setTypeId(typeDTO.getTypeId());
        type.setTypeName(typeDTO.getTypeName());
        type.setTypeDescription(typeDTO.getTypeDescription());
        type.setIsActive(typeDTO.getIsActive());
        return type;
    }


    /**
     * convert from type to typeDTO
     *
     * @param type
     * @return typeDTO
     */
    public TypeDTO convertToDTO(Type type) {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setTypeId(type.getTypeId());
        typeDTO.setTypeName(type.getTypeName());
        typeDTO.setTypeDescription(typeDTO.getTypeDescription());
        return typeDTO;
    }
}
