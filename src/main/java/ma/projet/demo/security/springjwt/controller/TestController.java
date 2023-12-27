package ma.projet.demo.security.springjwt.controller;


import ma.projet.demo.security.springjwt.models.User;
import ma.projet.demo.security.springjwt.security.jwt.services.UserDetailsServiceImpl;
import ma.projet.demo.security.springjwt.security.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private UserService userService2;


    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }


    @GetMapping("/userss")
    public List<ma.projet.demo.security.springjwt.models.User> findAll() {
        return userService2.findAll();
    }

    @GetMapping("/username/{username}")
    //@PreAuthorize("hasRole('ADMIN')")
    public UserDetails findByUsername(@PathVariable String username) {
        return userService.loadUserByUsername(username);
    }

    @GetMapping("/findbyusername/{username}")
    //@PreAuthorize("hasRole('ADMIN')")
    public User findByUserName(@PathVariable String username) {
        return userService.findByUsername(username);
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
