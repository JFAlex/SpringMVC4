package com.example.controller;

import com.example.Repository.ProfileRepository;
import com.example.date.LocalDateFormatter;
import com.example.dto.ProfileForm;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm, Model model){
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile" ,method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "profile/profilePage";
        }
       profileRepository.save(profileForm);
        System.out.println("Save Ok"+profileForm);
        return "redirect:profile";
    }

    @ModelAttribute("dataFormat")
    public String localeFormat(Locale locale){
        return LocalDateFormatter.getPattern(locale);
    }
}

