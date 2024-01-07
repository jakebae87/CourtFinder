package com.jake.courtfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jake.courtfinder.model.Comment;
import com.jake.courtfinder.model.Map;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query("SELECT c FROM Comment c WHERE c.map = :map")
	List<Comment> findCommentsById(Map map);
}
