package com.example.demo.controller;

import com.example.demo.constant.SystemConstant;
import com.example.demo.entity.User;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.R;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

//@Api(value = "用户接口", tags = {"用户接口"})
@CrossOrigin
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {


//    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R login(){
//        User currentUser = userService.login(user);
//        if(currentUser==null){
//            //认证失败
//            return R.success(currentUser);
//        }else {
            //认证成功  向前端 发送token
        String token = JwtUtils.createJWT(String.valueOf(1),"admin", SystemConstant.JWT_TTL);
        return R.success(token);
//        }
    }

//    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public R info(String token){
        System.out.println(token);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return R.success(map);
    }
}
