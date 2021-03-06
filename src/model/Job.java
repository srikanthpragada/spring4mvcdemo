package model;

import javax.validation.constraints.Size;

public class Job {

	@Size(min = 4, message="Minimum size must be 4")
	private String id;
	@Size(min = 6, message="Minimum size must be 6")
	private String title;

	
	public Job() {
		super();
	}

	public Job(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
