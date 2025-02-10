package com.example.springboot01.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot01.utils.CustomRespons;

import jakarta.servlet.http.HttpServletResponse;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/users")
public class UsersController {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private UsersService usersService;
    
    @GetMapping("/ping")
    public String pingPong() {
        log.info("pingPong() message");
        return "ping pong";
        // @RequestParam("param") String param
        // if(param.equals("ping")) {
        //     return new String("pong");
        // } else {
        //     return new String("input is not ping");
        // }        
    }

    @PostMapping("/regist")
    public String postRegist(UsersDTO param) {
        log.info("postRegist() message");
        UsersEntity entity = new UsersEntity();

        entity.setUsersAccount(param.getUsersAccount());
        entity.setUsersPassword(param.getUsersPassword());

        UsersEntity result = usersService.save(entity);
        return result.getUsersUUID().toString();
    }
    

    @GetMapping("/findAll")
    public CustomRespons getFindAll() {
        log.info("getFindAll() message");
        CustomRespons response = new CustomRespons();
        
        List<UsersEntity> data = usersService.findAll();
        // data.forEach(d -> System.out.println(d.toString()));
        response.setStatusCode(HttpServletResponse.SC_OK);
        response.setData(data);
        response.setMessage("Success");

        return response;
    }

}
