package com.example.spring_rest_apis.dto;

import java.math.BigDecimal;

public class CourseDTO {

	private Long id;
    private String title;
    private int totalHours;
    private BigDecimal price;
    private Boolean active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CourseDTO [id=" + id + ", title=" + title + ", totalHours=" + totalHours + ", price=" + price
				+ ", active=" + active + "]";
	}
    
    
}
