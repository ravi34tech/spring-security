package com.ravi.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
/**
 *  when we want to use the html thymleaf we need to add @controller annotation
 */
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<center><h1>Welcome Spring Security home Demo...</h1></center>";
     //   return "homePage";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h2>Welcome Admin ****!</h2>";
    }
    @GetMapping("/admin/check")
    public String adminCheck() {
        return "<h2>Welcome Admin Check ****!</h2>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h2>Welcome User.....!</h2>";
    }

    @GetMapping("/user/check")
    public String userCheck() {
        return "<h2>Welcome User Check.....!</h2>";
    }

    @GetMapping("/test")
    public String test() {
        return "<h2>Welcome Test.....!</h2>";
    }

    @GetMapping("/test/check")
    public String testCheck() {
        return "<h2>Welcome Test Check.....!</h2>";
    }

    @GetMapping("/all")
    public String all() {
        return "<h2>Welcome All!</h2>";
    }

    @GetMapping("/accessDenied")
    public String getAccessDeniedPage() {
        return "<h2>AccessDenied.....!</h2>";
        // return "accessDeniedPage";
    }

}
