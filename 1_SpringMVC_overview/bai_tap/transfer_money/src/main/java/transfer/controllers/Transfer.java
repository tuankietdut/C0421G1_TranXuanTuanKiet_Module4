package transfer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Transfer {
    @RequestMapping(value = "/transfer")
    public String transfer(@RequestParam("usa") double money, @RequestParam("rate") double rate , Model model){
        double moneyVND = money*rate;
        model.addAttribute("moneyVND", moneyVND);
        return "result";
    }

}
