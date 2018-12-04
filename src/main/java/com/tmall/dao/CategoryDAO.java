package com.tmall.dao;
import com.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 集成了 JpaRepository，提供了CRUD和分页 的各种常见功能
 */
public interface CategoryDAO extends JpaRepository<Category,Integer> {



}
