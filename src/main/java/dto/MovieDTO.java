package dto;


import java.util.Date;

public class MovieDTO extends BaseEntityDTO{
    private int movieId;

    private String actor;

    private String content;

    private String director;

    private double duration;

    private Date fromDate;

    private Date toDate;

    private String movieProductionCompany;

    private String version;

    private String movieNameEn;

    private String movieNameVn;

    private String largeImage;

    private String smallImage;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId='" + movieId + '\'' +
                ", actor='" + actor + '\'' +
                ", content='" + content + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", movieProductionCompany='" + movieProductionCompany + '\'' +
                ", version='" + version + '\'' +
                ", movieNameEn='" + movieNameEn + '\'' +
                ", movieNameVn='" + movieNameVn + '\'' +
                ", largeImage='" + largeImage + '\'' +
                ", smallImage='" + smallImage + '\'' +
                '}';
    }
}
