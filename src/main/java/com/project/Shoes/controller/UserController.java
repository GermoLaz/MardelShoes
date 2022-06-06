//package com.project.Shoes.controller;
//
//import com.project.Shoes.model.Client;
//import com.project.Shoes.model.User;
//import com.project.Shoes.service.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/client")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/")
//    public User add(@RequestBody final User user){
//        return userService.add(user);
//    }
//
//    @GetMapping("/{dni}")
//    public User findByDni(@PathVariable String dni) {
//        return userService.findByDni(dni);
//    }
//
//}
