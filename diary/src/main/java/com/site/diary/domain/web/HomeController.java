package com.site.diary.domain.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.site.diary.domain.dto.LogEntity;
import com.site.diary.domain.repository.LogRepository;
import com.site.diary.domain.service.LogService;

@Controller
public class HomeController {

    @Autowired
    private LogRepository logRepository;
    
    @Autowired
    private LogService logService;
	
    @GetMapping("/")
    public String goToMainPage() {
        return "main/home";
    }
    
}

