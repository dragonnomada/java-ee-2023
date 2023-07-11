package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.Date;

@XmlRootElement
@XmlType(propOrder = { "id", "title", "checked", "created" })
public class Todo {

    private Long id;
    private String title;
    private Boolean checked;
    private Date created;
    private Date updated;
    
    // ... getters and setters
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
	@XmlElement(name="isChecked")
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	@XmlAttribute(name="createdAt")
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@XmlTransient
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	// ... toString()
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", checked=" + checked + ", created=" + created + ", updated="
				+ updated + "]";
	}
	
}