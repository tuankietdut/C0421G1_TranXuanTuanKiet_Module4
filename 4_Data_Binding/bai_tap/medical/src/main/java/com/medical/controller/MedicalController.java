package com.medical.controller;

import com.medical.model.bean.Medical;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medical")
public class MedicalController {
    private Medical medical;

    @GetMapping("")
    public String showCreate(Model model){
        model.addAttribute("medical", new Medical());
        String[] genderArr = {"Male", "FeMale", "LGBT"};
        model.addAttribute("gender", genderArr);
        String[] travel = {"Tàu bay", " Tàu thuyền", "Ô tô", "Khác (ghi rõ)"};
        model.addAttribute("travel", travel);
        return "home";
    }

    @PostMapping("/create")
    public String createMedical(@ModelAttribute Medical medical, Model model){
        this.medical = medical;
        model.addAttribute("message", "Đã gửi form y tế, cảm ơn sự hợp tác của bạn");
        return "edit";
    }

    @GetMapping("/show")
    public String showMedical(Model model){
        model.addAttribute("medical", this.medical);
        String[] genderArr = {"Male", "FeMale", "LGBT"};
        model.addAttribute("gender", genderArr);
        String[] travel = {"Tàu bay", " Tàu thuyền", "Ô tô", "Khác (ghi rõ)"};
        model.addAttribute("travel", travel);
        return "home";
    }
}
