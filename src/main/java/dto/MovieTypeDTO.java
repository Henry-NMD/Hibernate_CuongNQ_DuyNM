package dto;

public class MovieTypeDTO {
    private MovieDTO movieDTO;
    private TypeDTO typeDTO;
    private String mtDescription;

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public TypeDTO getTypeDTO() {
        return typeDTO;
    }

    public void setTypeDTO(TypeDTO typeDTO) {
        this.typeDTO = typeDTO;
    }

    public String getMtDescription() {
        return mtDescription;
    }

    public void setMtDescription(String mtDescription) {
        this.mtDescription = mtDescription;
    }
}
