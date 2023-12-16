package com.example.demo.dao;

import com.example.demo.entity.Workers;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkersDao {

    int insert(Workers workers);

    List<Workers> selectAll(Workers workersQuery);

    Workers selectById(Long id);

    int deleteById(Long id);

    int updateById(Workers workers);
}
