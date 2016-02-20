package tw.org.sekainoane.standardmodel.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import tw.org.sekainoane.standardmodel.common.entity.GenericEntity;

@SuppressWarnings("serial")
@Getter
@Setter
@Entity(name = "ROUTE")
public class Route extends GenericEntity {

	@Column(name = "RECORD_TYPE")
	private String recordType;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "CONTENT1")
	private String content1;

	@Column(name = "CONTENT2")
	private String content2;

	@Column(name = "CONTENT4")
	private String content4;

	@Column(name = "START_TIME")
	private String startTime;

	@Column(name = "FINISH_TIME")
	private String finishTime;

	@Column(name = "PRICE")
	private String price;

}
