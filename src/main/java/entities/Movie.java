package entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "movie_table")
public class Movie extends BaseEntity {

	@Id
	@Column(name = "movie_id", length = 10, unique = true)
	private String movieId;
	
	@Column(name = "actor", length = 255, nullable = false)
	private String actor;
	
	@Column(name = "content", length = 1000, nullable = false)
	private String content;
	
	@Column(name = "director", length = 255, nullable = false)
	private String director;
	
	@Column(name = "duration", nullable = false)
	private double duration;
	
	@Column(name = "from_date", nullable = false)
	private Date fromDate;
	
	@Column(name = "to_date", nullable = false)
	private Date toDate;
	
	@Column(name = "movie_production_company", length = 255, nullable = false)
	private String movieProductionCompany;
	
	@Column(name = "version", length = 255, nullable = false)
	private String version;
	
	@Column(name = "movie_name_en", length = 255, nullable = false, unique = true)
	private String movieNameEn;
	
	@Column(name = "movie_name_vn", length = 255, nullable = false, unique = true)
	private String movieNameVn;
	
	@Column(name = "large_image", length = 255, nullable = false)
	private String largeImage;
	
	@Column(name = "small_image", length = 255, nullable = false)
	private String smallImage;
	
	@OneToMany(mappedBy = "primaryKey.movie")
	private List<MovieType> mtMovieType;
	
	public Movie() {
		
	}

	public Movie(String movieId, String actor, String content, String director, double duration, Date fromDate,
			Date toDate, String movieProductionCompany, String version, String movieNameEn, String movieNameVn,
			String largeImage, String smallImage) {
		super();
		this.movieId = movieId;
		this.actor = actor;
		this.content = content;
		this.director = director;
		this.duration = duration;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.movieProductionCompany = movieProductionCompany;
		this.version = version;
		this.movieNameEn = movieNameEn;
		this.movieNameVn = movieNameVn;
		this.largeImage = largeImage;
		this.smallImage = smallImage;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getMovieProductionCompany() {
		return movieProductionCompany;
	}

	public void setMovieProductionCompany(String movieProductionCompany) {
		this.movieProductionCompany = movieProductionCompany;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMovieNameEn() {
		return movieNameEn;
	}

	public void setMovieNameEn(String movieNameEn) {
		this.movieNameEn = movieNameEn;
	}

	public String getMovieNameVn() {
		return movieNameVn;
	}

	public void setMovieNameVn(String movieNameVn) {
		this.movieNameVn = movieNameVn;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public List<MovieType> getMtMovieType() {
		return mtMovieType;
	}

	public void setMtMovieType(List<MovieType> mtMovieType) {
		this.mtMovieType = mtMovieType;
	}
	
	
	
}
