package com.jim.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jim on 2017/1/5.
 * This class is ...
 */
@Entity
@Table(name = "comments", schema = "ebook")
public class CommentsEntity {
	private long id;
	private long parentId;
	private String title;
	private String content;
	private long userId;
	private String status;
	private byte rating;
	private long bookId;
	private String ipAddress;
	private String email;
	private Timestamp createAt;
	private Timestamp updateAt;

	@Id
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "parent_id", nullable = false)
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "content", nullable = false, length = -1)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Basic
	@Column(name = "rating", nullable = false)
	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	@Basic
	@Column(name = "book_id", nullable = false)
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	@Basic
	@Column(name = "ip_address", nullable = false, length = 50)
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Basic
	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "create_at", nullable = false)
	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	@Basic
	@Column(name = "update_at", nullable = false)
	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		CommentsEntity that = (CommentsEntity) o;

		if (id != that.id) return false;
		if (parentId != that.parentId) return false;
		if (userId != that.userId) return false;
		if (rating != that.rating) return false;
		if (bookId != that.bookId) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		if (content != null ? !content.equals(that.content) : that.content != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (ipAddress != null ? !ipAddress.equals(that.ipAddress) : that.ipAddress != null) return false;
		if (email != null ? !email.equals(that.email) : that.email != null) return false;
		if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
		if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (int) (parentId ^ (parentId >>> 32));
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (int) (userId ^ (userId >>> 32));
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (int) rating;
		result = 31 * result + (int) (bookId ^ (bookId >>> 32));
		result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
		result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
		return result;
	}
}
