package service;

import convert.ConvertTypeMovie;
import dao.MovieTypeDao;
import dto.MovieDTO;
import dto.MovieTypeDTO;
import dto.TypeDTO;
import entities.Movie;
import entities.MovieType;
import exception.IdExits;
import utils.Contants;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieTypeService {
    private MovieType movieType = new MovieType();
    private MovieTypeDao movieTypeDao = new MovieTypeDao();
    private ConvertTypeMovie convertTypeMovie = new ConvertTypeMovie();
    private TypeService typeService = new TypeService();
    private MovieService movieService = new MovieService();

    public String saveMovieService(MovieTypeDTO movieTypeDTO) throws Exception{
        int statusSaveType = 0;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        movieType = convertTypeMovie.convertToModel(movieTypeDTO);
        List<TypeDTO> dtoList = typeService.getAllType("check");

        int i = 0;
        if (!dtoList.isEmpty() || dtoList != null) {
            for (TypeDTO dto : dtoList) {
                if (movieTypeDTO.getTypeDTO().getTypeId() == dto.getTypeId()) {
                    i++;
                    break;
                }
            }
            if (i == 0) {
                throw new IdExits("please save type before save movie_type.");
            }
        } else {
            throw new IdExits("please save type before save movie_type.");
        }

        List<MovieDTO> movieDTOList = movieService.getAllMovie("check");
        int k = 0;
        if (!dtoList.isEmpty() || dtoList != null) {
            for (MovieDTO dto : movieDTOList) {
                if (movieTypeDTO.getMovieDTO().getMovieId() == dto.getMovieId()) {
                    k++;
                    break;
                }
            }
            if (k == 0) {
                throw new IdExits("please save movie before save movie_type.");
            }
        } else {
            throw new IdExits("please save movie before save movie_type.");
        }
        Set<ConstraintViolation<MovieType>> constraintViolations = validator.validate(movieType);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<MovieType> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            statusSaveType = movieTypeDao.add(movieType);
        }

        if (statusSaveType == 0) {
            return Contants.SUCCESS;
        } else {
            return Contants.FAIL;
        }
    }
}
