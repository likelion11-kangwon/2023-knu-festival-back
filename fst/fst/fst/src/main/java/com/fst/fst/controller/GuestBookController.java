package com.fst.fst.controller;

import com.fst.fst.Service.GuestBookService;
import com.fst.fst.dto.GuestBookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("guestbook")
public class GuestBookController {
    private final GuestBookService guestbookService;

    public GuestBookController(GuestBookService service) {
        this.guestbookService = service;
    }
    @GetMapping("/")
    public String index(){
        return "redirect:/guestbook/list";
    }

    @GetMapping("/list")
    public void list(){

    }
    @GetMapping("/register")
    public void register(){

    }
    @PostMapping("/register")
    public String register(GuestBookDTO guestbookDTO, RedirectAttributes redirectAttributes) {



        Long registeredGno =guestbookService.register(guestbookDTO);


        redirectAttributes.addFlashAttribute("msg", "success");

        return "redirect:/guestbook/list";
    }
}
