package com.dawes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "postcategorias")
public class PostCategoriaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPostCategoria;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private PostVO postId;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private CategoryVO categoryId;
	
	
	public PostCategoriaVO(int idPostCategoria, PostVO postId, CategoryVO categoryId) {
		this.idPostCategoria = idPostCategoria;
		this.postId = postId;
		this.categoryId = categoryId;
	}


	public PostCategoriaVO(PostVO postId, CategoryVO categoryId) {
		this.postId = postId;
		this.categoryId = categoryId;
	}
	
	public PostCategoriaVO() {
	}


	public int getIdPostCategoria() {
		return idPostCategoria;
	}


	public void setIdPostCategoria(int idPostCategoria) {
		this.idPostCategoria = idPostCategoria;
	}


	public PostVO getPostId() {
		return postId;
	}


	public void setPostId(PostVO postId) {
		this.postId = postId;
	}


	public CategoryVO getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(CategoryVO categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPostCategoria;
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
		PostCategoriaVO other = (PostCategoriaVO) obj;
		if (idPostCategoria != other.idPostCategoria)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PostCategoriaVO [idPostCategoria=" + idPostCategoria + ", postId=" + postId + ", categoryId="
				+ categoryId + "]";
	}
	
	
}
