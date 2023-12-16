package com.example.demo;

import com.example.demo.dao.WorkersDao;
import com.example.demo.entity.Workers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private WorkersDao workersDao;

    @Test
    void workersTest() {
//        List<Workers> workers = workersDao.selectAll();
//        System.out.println("workers::::"+workers);
    }
}
