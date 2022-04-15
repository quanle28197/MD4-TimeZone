package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/world-clock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
//        Lay ra thoi gian hien tai
        Date date = new Date();
//        Lay ra timezone hien tai
        TimeZone local = TimeZone.getDefault();
//        Lay ra timezone cua thanh pho cu the
        TimeZone locale = TimeZone.getTimeZone(city);
//        Tinh thoi gian hien tai cua mot thanh pho cu the
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
