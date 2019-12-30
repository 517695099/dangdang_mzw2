package mzw.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private String id;
	private String name;
	private String parent_id;
	private Integer levels;
	private Category cate;
	private List<Book> books;
	private List<Category> categories;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String name, String parent_id, Integer levels,
			Category cate, List<Book> books, List<Category> categories) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.levels = levels;
		this.cate = cate;
		this.books = books;
		this.categories = categories;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public Category getCate() {
		return cate;
	}
	public void setCate(Category cate) {
		this.cate = cate;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((cate == null) ? 0 : cate.hashCode());
		result = prime * result
				+ ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parent_id == null) ? 0 : parent_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (cate == null) {
			if (other.cate != null)
				return false;
		} else if (!cate.equals(other.cate))
			return false;
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent_id == null) {
			if (other.parent_id != null)
				return false;
		} else if (!parent_id.equals(other.parent_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent_id="
				+ parent_id + ", levels=" + levels + ", cate=" + cate
				+ ", books=" + books + ", categories=" + categories + "]";
	}
	
}
