package com.skcc.nxm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cards")
public class CardController {

    @GetMapping("/sample1")
    public @ResponseBody String sample1() {
       try {
           Thread.sleep(3000);
       }catch (InterruptedException e) {
           e.printStackTrace();
       };

        return "card test";
    }

    @GetMapping("/sample2")
    public @ResponseBody String sample2() throws Exception{
        try {
            throw new Exception("card error");
        }catch (InterruptedException e) {
            e.printStackTrace();
        };

        return "card exception test";
    }


}
