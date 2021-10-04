package convert;

import dto.MovieTypeDTO;
import dto.TypeDTO;
import entities.MovieType;
import entities.Type;

public class ConvertTypeMovie {
    private ConvertType convertType = new ConvertType();
    private ConvertMovie convertMovie = new ConvertMovie();
    /**
     * convert from movieTypeDTO  to movieType
     *
     * @param movieTypeDTO
     * @return movieType object
     */
    public MovieType convertToModel(MovieTypeDTO movieTypeDTO) {
        MovieType movieType = new MovieType();
        movieType.setType(convertType.convertToModel(movieTypeDTO.getTypeDTO()));
        movieType.setMovie(convertMovie.convertToModel(movieTypeDTO.getMovieDTO()));
        movieType.setMtDescription(movieTypeDTO.getMtDescription());
        return movieType;

    }
}
