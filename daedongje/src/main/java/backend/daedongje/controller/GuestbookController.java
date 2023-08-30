package backend.daedongje.controller;

import backend.daedongje.dto.GuestbookDTO;
import backend.daedongje.dto.PageRequestDTO;
import backend.daedongje.service.GuestbookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("guestbook")
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService service) {
        this.guestbookService = service;
    }

    @GetMapping("/")
    public String index() {


        return "redirect:/guestbook/list";
    }

    //방명록 목록 get
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("pageResponseDTO", guestbookService.list(pageRequestDTO));

    }

    @GetMapping("/register")
    public void register() {


    }

    @PostMapping("/register")
    public String register(GuestbookDTO guestbookDTO, RedirectAttributes redirectAttributes) {

        Long registeredGno = guestbookService.register(guestbookDTO);


        redirectAttributes.addFlashAttribute("msg", "success");

        return "redirect:/guestbook/list";
    }

    @GetMapping("/read")
    public void read(Long id, @ModelAttribute("pageRequestDTO") PageRequestDTO dto, Model model) {


        model.addAttribute("guestbookDTO", guestbookService.read(id));

    }


}