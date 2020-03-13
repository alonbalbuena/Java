package com.dawes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.CommentVO;
@Repository

public interface CommentDAO extends CrudRepository<CommentVO, Integer> {

	CommentVO findByComment(String comment);
}
