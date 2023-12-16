package com.example.demo.controller;

import com.example.demo.dao.WorkersDao;
import com.example.demo.entity.Workers;
import com.example.demo.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
@AllArgsConstructor
@Api(value = "员工相关接口", tags = {"员工相关接口"})
public class WorkersController {

    private final WorkersDao workersDao;

    @ApiOperation(value = "获取员工信息")
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

        return R.successPage(workers.subList(firstIndex, lastIndex), workersSize); //直接在list中截取
    }

    @ApiOperation(value = "添加员工信息")
    @PostMapping("/staff/add")
    public R<Integer> addWorkers(Workers workers) {
        int insert = workersDao.insert(workers);
        if (insert == 0){
            return R.fail("添加员工信息失败");
        }
        return R.success(insert);
    }

    @ApiOperation(value = "修改员工信息")
    @PostMapping("/staff/edit")
    public R<Integer> editWorkers(Workers workers) {
        int update = workersDao.updateById(workers);
        if (update == 0){
            return R.fail("修改员工信息失败");
        }
        return R.success(update);
    }

    @ApiOperation(value = "删除员工信息")
    @GetMapping ("/staff/del")
    public R<Integer> delWorkers(@RequestParam long id) {
        int delete = workersDao.deleteById(id);
        if (delete == 0){
            return R.fail("删除员工信息失败");
        }
        return R.success(delete);
    }
}
