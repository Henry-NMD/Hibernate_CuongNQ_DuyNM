package entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

	@Column (name = "save_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "update_name")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	@Column(name = "active")
	private String isActive; // soft delete

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
			this.isActive = isActive;
	}
}
