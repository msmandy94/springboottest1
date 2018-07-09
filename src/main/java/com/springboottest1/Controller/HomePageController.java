package com.springboottest1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mandeepsingh on 4/15/18.
 */
@RestController
@RequestMapping("/")
public class HomePageController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(){
        return "Home Page.\nPlease use /productcatalog/all to get all products";
    }
}
