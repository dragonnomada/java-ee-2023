package com.example.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

// JAXB

@XmlRootElement
public class Todo {

	private Long id;
	private String title;
	private Boolean checked;
	private Date created;
	private Date updated;
	private String metadata;
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlAttribute(name="isChecked")
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	@XmlElement(name="createdAt")
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@XmlElement(name="updatedAt")
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@XmlTransient
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", checked=" + checked + ", created=" + created + ", updated="
				+ updated + "]";
	}
	
}

/*
 * <todo id="123" isChecked="true">
 * 	<title>Comprar fruta</title>
 *  <createdAt>2023-07-12T10:12:00</createdAt>
 *  <updatedAt>2023-07-12T10:15:00</updatedAt>
 * </todo>
 */