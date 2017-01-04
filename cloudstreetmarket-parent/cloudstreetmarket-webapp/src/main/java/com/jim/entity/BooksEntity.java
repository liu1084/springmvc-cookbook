package com.jim.entity;

import javax.persistence.*;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
@Entity
@Table(name = "books", schema = "ebook", catalog = "")
public class BooksEntity {
	private long id;
	private String name;
	private String description;
	private String cover;
	private String author;
	private String isbn;
	private String year;
	private int pages;
	private String language;
	private double size;
	private String format;
	private long category;
	private byte rating;

	@Id
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "description", nullable = false, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "cover", nullable = false, length = 100)
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Basic
	@Column(name = "author", nullable = false, length = 100)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Basic
	@Column(name = "isbn", nullable = false, length = 50)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Basic
	@Column(name = "year", nullable = false, length = 10)
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Basic
	@Column(name = "pages", nullable = false)
	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Basic
	@Column(name = "language", nullable = false, length = 50)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Basic
	@Column(name = "size", nullable = false, precision = 0)
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Basic
	@Column(name = "format", nullable = false, length = 50)
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Basic
	@Column(name = "category", nullable = false)
	public long getCategory() {
		return category;
	}

	public void setCategory(long category) {
		this.category = category;
	}

	@Basic
	@Column(name = "rating", nullable = false)
	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BooksEntity that = (BooksEntity) o;

		if (id != that.id) return false;
		if (pages != that.pages) return false;
		if (Double.compare(that.size, size) != 0) return false;
		if (category != that.category) return false;
		if (rating != that.rating) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (description != null ? !description.equals(that.description) : that.description != null) return false;
		if (cover != null ? !cover.equals(that.cover) : that.cover != null) return false;
		if (author != null ? !author.equals(that.author) : that.author != null) return false;
		if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;
		if (year != null ? !year.equals(that.year) : that.year != null) return false;
		if (language != null ? !language.equals(that.language) : that.language != null) return false;
		if (format != null ? !format.equals(that.format) : that.format != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (cover != null ? cover.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		result = 31 * result + (year != null ? year.hashCode() : 0);
		result = 31 * result + pages;
		result = 31 * result + (language != null ? language.hashCode() : 0);
		temp = Double.doubleToLongBits(size);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (format != null ? format.hashCode() : 0);
		result = 31 * result + (int) (category ^ (category >>> 32));
		result = 31 * result + (int) rating;
		return result;
	}
}
