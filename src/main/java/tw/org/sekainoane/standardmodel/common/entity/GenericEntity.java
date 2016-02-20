package tw.org.sekainoane.standardmodel.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class GenericEntity implements Serializable {
	
	@Column(name = "ID")
	private Long id;

	@Column(name = "CREATE_USER")
	private String createUser;

	@Column(name = "CREATE_TIME")
	private LocalDateTime createTime;

	@Column(name = "MODIFY_USER")
	private String modifyUser;

	@Column(name = "MODIFY_TIME")
	private LocalDateTime modifyTime;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final GenericEntity other = (GenericEntity) obj;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		return true;
	}

}
