package edu.vinaenter.models;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

	private String id;

	private String title;

	private String author;

	private Date createdBy;

	private String detail;

	private int status;

	private MultipartFile pic;

	private String picture;

	public News(String id, String title, String author, Date createdBy, String detail, int status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.createdBy = createdBy;
		this.detail = detail;
		this.status = status;
	}

}
