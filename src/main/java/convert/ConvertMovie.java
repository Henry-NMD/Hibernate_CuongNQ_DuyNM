package convert;

import dto.MovieDTO;
import entities.Movie;

import java.sql.Date;

public class ConvertMovie {

    /**
     * convert from movieDTO  to movie
     * @param movieDTO
     * @return movie
     */
    public Movie convertToModel(MovieDTO movieDTO) {

        Movie movie = new Movie();

        movie.setMovieId(movieDTO.getMovieId());
        movie.setActor(movieDTO.getActor());
        movie.setContent(movieDTO.getContent());
        movie.setDirector(movieDTO.getDirector());
        movie.setDuration(movieDTO.getDuration());
        movie.setMovieProductionCompany(movieDTO.getMovieProductionCompany());
        movie.setFromDate((Date) movieDTO.getFromDate());
        movie.setToDate((Date) movieDTO.getToDate());
        movie.setVersion(movieDTO.getVersion());
        movie.setMovieNameEn(movieDTO.getMovieNameEn());
        movie.setMovieNameVn(movieDTO.getMovieNameVn());
        movie.setLargeImage(movieDTO.getLargeImage());
        movie.setSmallImage(movieDTO.getSmallImage());
        movie.setIsActive(movieDTO.getIsActive());

        return movie;
    }

    /**
     * convert from movie  to movieDTO
     * @param movie
     * @return movieDTO
     */
    public MovieDTO convertToDTO(Movie movie) {

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setMovieId(movie.getMovieId());
        movieDTO.setActor(movie.getActor());
        movieDTO.setContent(movie.getContent());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setMovieProductionCompany(movie.getMovieProductionCompany());
        movieDTO.setFromDate(movie.getFromDate());
        movieDTO.setToDate(movie.getToDate());
        movieDTO.setVersion(movie.getVersion());
        movieDTO.setMovieNameEn(movie.getMovieNameEn());
        movieDTO.setMovieNameVn(movie.getMovieNameVn());
        movieDTO.setLargeImage(movie.getLargeImage());
        movieDTO.setSmallImage(movie.getSmallImage());

        return movieDTO;
    }
}
