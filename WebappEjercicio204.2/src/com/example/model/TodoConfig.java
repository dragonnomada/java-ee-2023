package com.example.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TodoConfig {

	private Long nextId;
	private String defaultTitle;
	private Boolean defaultChecked;
	private Date defaultDate;
	
	@XmlAttribute
	public Long getNextId() {
		return nextId;
	}
	public void setNextId(Long nextId) {
		this.nextId = nextId;
	}
	@XmlElement
	public String getDefaultTitle() {
		return defaultTitle;
	}
	public void setDefaultTitle(String defaultTitle) {
		this.defaultTitle = defaultTitle;
	}
	@XmlAttribute
	public Boolean getDefaultChecked() {
		return defaultChecked;
	}
	public void setDefaultChecked(Boolean defaultChecked) {
		this.defaultChecked = defaultChecked;
	}
	@XmlElement
	public Date getDefaultDate() {
		return defaultDate;
	}
	public void setDefaultDate(Date defaultDate) {
		this.defaultDate = defaultDate;
	}
	
	@Override
	public String toString() {
		return "TodoConfig [nextId=" + nextId + ", defaultTitle=" + defaultTitle + ", defaultChecked=" + defaultChecked
				+ ", defaultDate=" + defaultDate + "]";
	}
	
}
