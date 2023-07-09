import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "demo")
@XmlType(propOrder = { "id", "title", "date" })
public class Demo {

	private Long id;
	private String title;
	private Date date;
	
//	@XmlAttribute
	public Long getId() {
		return id;
	}
	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}
//	@XmlElement
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
//	@XmlElement
	public Date getDate() {
		return date;
	}
	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Demo [id=" + id + ", title=" + title + ", date=" + date + "]";
	}
	
}
