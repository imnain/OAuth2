package com.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class controller {
    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }
    @GetMapping("/about")
    public String about(){
        return "this is about page";
    }
    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(@AuthenticationPrincipal OAuth2User principal) {

        DefaultOAuth2User userDetails =  (DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getAttribute("login");
    }
    @GetMapping("/getRole")
    public String currentRole(@AuthenticationPrincipal OAuth2User principal){
        return principal.getAttribute("type");
    }
    @GetMapping("/isAdmin")
    public boolean isAdmin(@AuthenticationPrincipal OAuth2User principal){
        return principal.getAttribute("site_admin");
    }



}
