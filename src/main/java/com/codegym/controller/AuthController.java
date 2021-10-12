package com.codegym.controller;

import com.codegym.dto.request.SignInForm;
import com.codegym.dto.request.SignUpForm;
import com.codegym.dto.response.JwtResponse;
import com.codegym.dto.response.MessageResponse;
import com.codegym.model.entity.Role;
import com.codegym.model.entity.User;
import com.codegym.security.jwt.JwtService;
import com.codegym.security.userprincal.UserPrinciple;
import com.codegym.service.email.EmailService;
import com.codegym.service.role.IRoleService;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequestMapping("")
@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUserName(signUpForm.getUserName()))
            return new ResponseEntity<>(new MessageResponse("This username is existed"), HttpStatus.OK);
        if (userService.existsByEmail(signUpForm.getEmail()))
            return new ResponseEntity<>(new MessageResponse("This email is existed"), HttpStatus.OK);
        User user = new User(signUpForm.getUserName(), signUpForm.getPassword(), signUpForm.getEmail(), signUpForm.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Role> role = roleService.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role.get());
        user.setRoles(roles);
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        user.setCreateAt(date);
        user.setStatusUs(0);
        user.setStatusCCDV(0);
        user.setAvatar("https://st.quantrimang.com/photos/image/072015/22/avatar.jpg");
        userService.save(user);
        if (user != null) {
            try {
                emailService.sendVerificationEmail(user);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(new MessageResponse("Register successfully"), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInForm.getUserName(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        User currentUser = userService.findByUserName(signInForm.getUserName()).get();
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userPrinciple.getUsername(), currentUser.getName(), userPrinciple.getAuthorities(), currentUser.getStatusUs()));
    }
}
