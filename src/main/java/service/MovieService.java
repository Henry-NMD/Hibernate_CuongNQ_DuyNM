package service;

import convert.ConvertMovie;
import dao.MovieDao;
import dto.MovieDTO;
import dto.TypeDTO;
import entities.Movie;
import entities.Type;
import exception.DuplicateException;
import utils.Contants;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieService {
    private Movie movie = new Movie();
    private ConvertMovie convertMovie = new ConvertMovie();
    private MovieDao movieDao = new MovieDao();

    /**
     * validator movieDTO and call Dao
     *
     * @param movieDTO
     * @return
     */
    public String saveMovieService(MovieDTO movieDTO) {
        int statusSaveType = 0;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        movie = convertMovie.convertToModel(movieDTO);
        statusSaveType = movieDao.add(movie);

//        List<TypeDTO> dtoList = getAllType("check");
//        if (!dtoList.isEmpty() || dtoList != null) {
//            for (TypeDTO dto : dtoList) {
//                if (typeDTO.getTypeId() == dto.getTypeId()) {
//                    throw new DuplicateException("duplicate type id: " + typeDTO.getTypeId());
//                }
//            }
//        }
//        Set<ConstraintViolation<Movie>> constraintViolations = validator.validate(movie);
//        if (constraintViolations.size() > 0) {
//            for (ConstraintViolation<Movie> violation : constraintViolations) {
//                System.out.println(violation.getMessage());
//            }
//        } else {
//            Date date = new Date();
//            movie.setCreatedDate(date);
//            movie.setIsActive("Y");
//            statusSaveType = movieDao.save(movie);
//        }

        if (statusSaveType == 0) {
            return Contants.SUCCESS;
        } else {
            return Contants.FAIL;
        }
    }

    /**
     * get all movie then convert to movieDTO
     *
     * @return list movieDTO object
     */
    public List<MovieDTO> getAllMovie(String status) {
        MovieDTO movieDTO;
        List<MovieDTO> movieDTOList = new ArrayList<>();
        List<Movie> list = movieDao.findAll(status);
        for (Movie movie : list) {
            movieDTO = new MovieDTO();
            movieDTO = convertMovie.convertToDTO(movie);
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }
}
