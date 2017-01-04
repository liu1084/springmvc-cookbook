package com.jim.entity;

import javax.persistence.*;

/**
 * Created by jim on 2017/1/4.
 * This class is ...
 */
@Entity
@Table(name = "categories", schema = "", catalog = "ebook")
public class EbookCategoriesEntity {
	private long id;
	private String name;

	@Id
	@Column(name = "id", nullable = false, insertable = true, updatable = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, insertable = true, updatable = true, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		EbookCategoriesEntity that = (EbookCategoriesEntity) o;

		if (id != that.id) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
