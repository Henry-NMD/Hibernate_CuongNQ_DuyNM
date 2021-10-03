package service;

import convert.ConvertMovie;
import dto.MovieDTO;
import dto.TypeDTO;
import entities.Type;
import exception.DuplicateException;
import utils.Contants;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieService {
    private ConvertMovie convertMovie = new ConvertMovie();
//    public String saveMovieService(MovieDTO movieDTO) {
//    }
}
