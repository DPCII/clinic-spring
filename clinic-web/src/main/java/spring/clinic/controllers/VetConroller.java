package spring.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetConroller {

    @RequestMapping("/vets")
    public String listVets() {

        return "vets/index";
    }
}
