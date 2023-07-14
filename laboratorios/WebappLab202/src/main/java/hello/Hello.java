package hello;

import java.io.Serializable;

public class Hello implements Serializable {

	private static final long serialVersionUID = -6136443260934837356L;
	
	private int id;
	private String title;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", title=" + title + "]";
	}

}
