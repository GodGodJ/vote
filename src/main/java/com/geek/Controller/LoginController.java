package com.geek.Controller;

import com.geek.Model.Council;
import com.geek.Model.Members;
import com.geek.Repository.CouncilRepository;
import com.geek.Service.CouncilService;
import com.geek.Service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private MembersService membersService;

    @Autowired
    private CouncilRepository councilRepository;


    @Autowired
    private CouncilService councilService;

    @GetMapping("{type}")
    public String loginPage(@PathVariable String type, Model model){
        model.addAttribute("type",type);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String number, @RequestParam String type,RedirectAttributes attributes, Model model) throws UnsupportedEncodingException {
        Members members = membersService.checkMembers(number);
        if (members != null){

            String en = URLEncoder.encode(number,"UTF-8");

                if (type.equals("0")){

                    if (number.equals("498895")){
                        List<Council> councils = councilRepository.findByOrderByAgreeDesc();
                        model.addAttribute("councils", councils);
                        return "successs";
                    }else{
                        return "redirect:/vote1?number="+en;
                    }


                } else if (type.equals("1")){
                    if (number.equals("498895")){
                        List<Council> councils0 = councilService.findbytypedesc(1);
                        List<Council> councils1 = councilService.findbytypedesc(2);
                        model.addAttribute("councils", councils0);
                        model.addAttribute("councilss",councils1);
                        return "successs2";
                    }else{
                        return "redirect:/vote2?number="+en;
                    }

                } else if (type.equals("2")){
                    if (number.equals("498895")){
                        List<Council> councils0 = councilService.findbytypedesc(3);
                        List<Council> councils1 = councilService.findbytypedesc(4);
                        List<Council> councils2 = councilService.findbytypedesc(5);
                        model.addAttribute("councils", councils0);
                        model.addAttribute("councilss",councils1);
                        model.addAttribute("councilsss",councils2);
                        return "successs3";
                    }else{
                        return "redirect:/vote3?number="+en;
                    }

                } else {
                    return "redirect:/login";

                }

            } else {
            attributes.addFlashAttribute("message","没有该身份号");
            return "redirect:/"+type;
        }


    }

}
