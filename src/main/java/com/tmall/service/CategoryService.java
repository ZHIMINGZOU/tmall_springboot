package com.tmall.service;

import com.tmall.dao.CategoryDAO;
import com.tmall.pojo.Category;
import com.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public Page4Navigator<Category>list(int start ,int size ,int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFromJPA = categoryDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<Category>list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id"); //根据id倒序查询
        return  categoryDAO.findAll(sort);
    }
}
