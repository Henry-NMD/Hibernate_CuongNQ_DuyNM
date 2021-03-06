package entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(schema = "dbo",name = "type_table")
public class Type extends BaseEntity {
	
	@Id
	@Column(name = "type_id", unique = true)
	private int typeId;

	@Column(name = "type_name", length = 255, nullable = false)
	private String typeName;

	@Size(max = 20, min = 3, message = "{type.description.invalid}")
	@Column(name = "type_description", length = 255, nullable = false)
	private String typeDescription;

	@OneToMany(mappedBy = "primaryKey.type", fetch = FetchType.EAGER)
	private List<MovieType> mtMovieTypes;
	
	public Type() {
		
	}

	public Type(int typeId, String typeName, String typeDescription) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDescription = typeDescription;
	}

	public int getTypeId() {
		return this.typeId;
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
	
	public List<MovieType> getMtMovieTypes() {
		return mtMovieTypes;
	}

	public void setMtMovieTypes(List<MovieType> mtMovieTypes) {
		this.mtMovieTypes = mtMovieTypes;
	}


}
