package entities;

import javax.persistence.*;

@Entity
@Table(schema = "dbo",name = "movie_type_table")
@AssociationOverrides({ @AssociationOverride(name = "primaryKey.movie", joinColumns = @JoinColumn(name = "movie_id")),
		@AssociationOverride(name = "primaryKey.type", joinColumns = @JoinColumn(name = "type_id")) })
public class MovieType{

	@EmbeddedId
	private MoveTypeId primaryKey =  new MoveTypeId();

	@Column(name = "mt_description", length = 255, nullable = false)
	private String mtDescription;

	
	public MovieType() {
		super();
	}

	public MovieType(MoveTypeId primaryKey, String mtDescription) {
		this.primaryKey = primaryKey;
		this.mtDescription = mtDescription;
	}

	public MoveTypeId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(MoveTypeId primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Transient
	public Movie getMovie() {
		return getPrimaryKey().getMovie();
	}

	public void setMovie(Movie movie) {
		getPrimaryKey().setMovie(movie);
	}

	@Transient
	public Type getType() {
		return getPrimaryKey().getType();
	}

	public void setType(Type type) {
		getPrimaryKey().setType(type);
	}


}
