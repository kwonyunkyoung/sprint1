package com.skcc.nxm.controller;


import com.skcc.nxm.domain.Member;
import com.skcc.nxm.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {


    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/sample1")
    public @ResponseBody String sample1(@RequestParam String mbrNm ) {
        return mbrNm;
    }

    @GetMapping("/sample2")
    public @ResponseBody Member sample2(@RequestBody Member member ) {
        return member;
    }

    @GetMapping("/sample3/{mbrId}")
    public @ResponseBody String sample3(@PathVariable("mbrId") String mbrId) {
        return mbrId;
    }

    @GetMapping("/sample4")
    public String sample4() {
        return "redirect:/result.html";
    }

    @GetMapping("/sample5")
    public @ResponseBody List<Member> sample5() {
        return memberService.findAll();
    }

    @GetMapping("/sample6")
    public String sample6(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);
        return "result.html";
    }

    @PostMapping("/add")
    public @ResponseBody String addItem(@RequestBody Member member) {
        memberService.save(member);
        return "save ok";
    }
}
