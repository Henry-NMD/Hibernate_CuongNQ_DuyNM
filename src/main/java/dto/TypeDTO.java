package dto;

import java.util.List;

public class TypeDTO extends BaseEntityDTO{
    private int typeId;
    private String typeName;
    private String typeDescription;
    private List<MovieTypeDTO> movieTypeDTOS;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public List<MovieTypeDTO> getMovieTypeDTOS() {
        return movieTypeDTOS;
    }

    public void setMovieTypeDTOS(List<MovieTypeDTO> movieTypeDTOS) {
        this.movieTypeDTOS = movieTypeDTOS;
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeDescription='" + typeDescription + '\'' +
                ", movieTypeDTOS=" + movieTypeDTOS +
                '}';
    }
}
