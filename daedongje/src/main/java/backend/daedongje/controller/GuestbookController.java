package backend.daedongje.controller;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.dto.PageRequestDTO;
import backend.daedongje.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guestbook")
public class GuestbookController {

    private final GuestbookService guestbookService;



    @GetMapping("/")
    public String index() {


        return "redirect:/guestbook/list";
    }

    //방명록 목록 get
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("pageResponseDTO", guestbookService.list(pageRequestDTO));

    }

    //방명록 등록 위한 페이지
    @GetMapping("/register")
    public void register() {


    }


    //방명록 등록 처리
    @PostMapping("/register")
    public String register(GuestbookDTO guestbookDTO, RedirectAttributes redirectAttributes) {

        Long registeredGno = guestbookService.register(guestbookDTO);


        redirectAttributes.addFlashAttribute("msg", "success");

        return "redirect:/guestbook/list";
    }
    
    //단일 방명록 조회
    @GetMapping("/read")
    public void read(Long id, @ModelAttribute("pageRequestDTO") PageRequestDTO dto, Model model) {
        model.addAttribute("guestbookDTO", guestbookService.read(id));

    }


}