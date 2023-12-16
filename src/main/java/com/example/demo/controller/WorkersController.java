package com.example.demo.controller;

import com.example.demo.dao.WorkersDao;
import com.example.demo.entity.Workers;
import com.example.demo.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@AllArgsConstructor
public class WorkersController {

    private final WorkersDao workersDao;

    @GetMapping("/staff/list")
    public R<List<Workers>> getWorkers(Workers workersQuery) {

        List<Workers> workers = workersDao.selectAll(workersQuery);
        int workersSize = workers.size();
        //从第几条数据开始
        int firstIndex = (workersQuery.getPage() - 1) * workersQuery.getLimit();
        //到第几条数据结束
        int lastIndex = workersQuery.getPage() * workersQuery.getLimit();
        if (lastIndex>workersSize){
            lastIndex = workersSize;
        }

        if (workers.size()==0){
            return R.fail("x");
        }
        return R.successPage(workers.subList(firstIndex, lastIndex), workersSize); //直接在list中截取
    }

    @PostMapping("/staff/add")
    public R<Integer> addWorkers(Workers workers) {
        int insert = workersDao.insert(workers);
        return R.success(insert);
    }

    @PostMapping("/staff/edit")
    public R<Integer> editWorkers(Workers workers) {
        int update = workersDao.updateById(workers);
        return R.success(update);
    }

    @GetMapping ("/staff/del")
    public R<Integer> delWorkers(@RequestParam long id) {
        int delete = workersDao.deleteById(id);
        return R.success(delete);
    }
}
