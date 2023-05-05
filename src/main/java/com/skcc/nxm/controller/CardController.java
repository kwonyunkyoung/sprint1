package com.skcc.nxm.controller;


import com.skcc.nxm.domain.Member;
import com.skcc.nxm.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cards")
public class CardController {

    @GetMapping("/sample1")
    public @ResponseBody String sample1() {
        return "card test";
    }


}
