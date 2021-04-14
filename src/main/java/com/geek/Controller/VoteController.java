package com.geek.Controller;

import com.geek.Model.Check;
import com.geek.Model.Council;
import com.geek.Model.Cro;
import com.geek.Model.CroForm;
import com.geek.Repository.CheckRepository;
import com.geek.Repository.CouncilRepository;
import com.geek.Service.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VoteController {

    @Autowired
    private CouncilService councilService;


    @Autowired
    private CouncilRepository councilRepository;

    @Autowired
    private CheckRepository checkRepository;





    @GetMapping("/vote1")
    public String vote1(@RequestParam String number, Model model){
        List<Council> councilList = councilService.finAll();

        model.addAttribute("councils",councilList);
        model.addAttribute("number",number);
        return "vote";
    }

    @GetMapping("/vote2")
    public String vote2(@RequestParam String number, Model model){
        List<Council> councilList = councilService.findbytype(1);
        List<Council> councilLists = councilService.findbytype(2);

        model.addAttribute("councils",councilList);
        model.addAttribute("councilss",councilLists);
        model.addAttribute("number",number);
        return "vote2";
    }

    @GetMapping("/vote3")
    public String vote3(@RequestParam String number, Model model){
        List<Council> councilList = councilService.findbytype(3);
        List<Council> councilLists = councilService.findbytype(4);
        List<Council> councilListss = councilService.findbytype(5);

        model.addAttribute("councils",councilList);
        model.addAttribute("councilss",councilLists);
        model.addAttribute("councilsss",councilListss);
        model.addAttribute("number",number);
        return "vote3";
    }

    @PostMapping("/results")
    public String results(CroForm croForm, @RequestParam String number) {
        Optional<Check> check1 = checkRepository.findByNumber(number);
        List<Cro> result1 = croForm.getResult1();
//        System.out.println(result.get(0).getName());
//        System.out.println(result.get(0).getResult());
//        System.out.println(number);
//        System.out.println(esult.size());
        if (check1.isPresent()){
            return "successpage";
        } else {

            for (int i=0;i<result1.size();i++){
                switch (result1.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result1.get(i).getName(),0);
                        break;
                    case "2" :
                        councilService.addAginst(result1.get(i).getName(),0);
                        break;
                    case "3" :
                        councilService.addawaiver(result1.get(i).getName(),0);
                        break;
                }
            }
            Check check = new Check(number);
            checkRepository.save(check);

            return "successpage";
        }




        /*Optional<Check> check = checkRepository.findByNumber(number);


        if (check.isPresent()) {
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        } else {
            //councilService.add(cm);
            Check check1 = new Check(number);
            checkRepository.save(check1);
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        }*/


    }


    @PostMapping("/results2")
    public String results2(CroForm croForm, @RequestParam String number) {
        Optional<Check> check1 = checkRepository.findByNumber(number);
        List<Cro> result1 = croForm.getResult1();
        List<Cro> result2 = croForm.getResult2();
//        System.out.println(result.get(0).getName());
//        System.out.println(result.get(0).getResult());
//        System.out.println(number);
//        System.out.println(esult.size());
        if (check1.isPresent()){
            return "successpage";
        } else {

            for (int i=0;i<result1.size();i++){
                switch (result1.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result1.get(i).getName(),1);
                        break;
                    case "2" :
                        councilService.addAginst(result1.get(i).getName(),1);
                        break;
                    case "3" :
                        councilService.addawaiver(result1.get(i).getName(),1);
                        break;
                }
            }
            for (int i=0;i<result2.size();i++){
                switch (result2.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result2.get(i).getName(),2);
                        break;
                    case "2" :
                        councilService.addAginst(result2.get(i).getName(),2);
                        break;
                    case "3" :
                        councilService.addawaiver(result2.get(i).getName(),2);
                        break;
                }
            }
            Check check = new Check(number);
            checkRepository.save(check);

            return "successpage";
        }

        /*Optional<Check> check = checkRepository.findByNumber(number);


        if (check.isPresent()) {
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        } else {
            //councilService.add(cm);
            Check check1 = new Check(number);
            checkRepository.save(check1);
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        }*/


    }







    @PostMapping("/results3")
    public String results3(CroForm croForm, @RequestParam String number) {
        Optional<Check> check1 = checkRepository.findByNumber(number);
        List<Cro> result1 = croForm.getResult1();
        List<Cro> result2 = croForm.getResult2();
        List<Cro> result3 = croForm.getResult3();
//        System.out.println(result.get(0).getName());
//        System.out.println(result.get(0).getResult());
//        System.out.println(number);
//        System.out.println(esult.size());
        if (check1.isPresent()){
            return "successpage";
        } else {

            for (int i=0;i<result1.size();i++){
                switch (result1.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result1.get(i).getName(),3);
                        break;
                    case "2" :
                        councilService.addAginst(result1.get(i).getName(),3);
                        break;
                    case "3" :
                        councilService.addawaiver(result1.get(i).getName(),3);
                        break;
                }
            }
            for (int i=0;i<result2.size();i++){
                switch (result2.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result2.get(i).getName(),4);
                        break;
                    case "2" :
                        councilService.addAginst(result2.get(i).getName(),4);
                        break;
                    case "3" :
                        councilService.addawaiver(result2.get(i).getName(),4);
                        break;
                }
            }
            for (int i=0;i<result3.size();i++){
                switch (result3.get(i).getResult()){
                    case "1" :
                        councilService.addAgree(result3.get(i).getName(),5);
                        break;
                    case "2" :
                        councilService.addAginst(result3.get(i).getName(),5);
                        break;
                    case "3" :
                        councilService.addawaiver(result3.get(i).getName(),5);
                        break;
                }
            }
            Check check = new Check(number);
            checkRepository.save(check);

            return "successpage";
        }

        /*Optional<Check> check = checkRepository.findByNumber(number);


        if (check.isPresent()) {
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        } else {
            //councilService.add(cm);
            Check check1 = new Check(number);
            checkRepository.save(check1);
            List<Council> councils = councilRepository.findByOrderByAgreeDesc();
            model.addAttribute("councils", councils);
            return "successs";
        }*/


    }

}
