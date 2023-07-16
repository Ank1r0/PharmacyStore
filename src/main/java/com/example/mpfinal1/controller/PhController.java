package com.example.mpfinal1.controller;

import com.example.mpfinal1.model.Licence;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.mpfinal1.service.EmployeeChemistLicence;
import org.springframework.ui.Model;

@Controller
@RequestMapping
@AllArgsConstructor
public class PhController {

    private final EmployeeChemistLicence service;



    @GetMapping("/")
    public String index() {
        return "redirect:/ChemistLicences    ";
    }

    @GetMapping("/ChemistLicences")
    public String showChemistLicences(Model model){
        model.addAttribute("ChemistsLicences",service.getAllChemistsPacks());
        return "start-page";
    }

    @GetMapping("/ChemistLicences/{ChemistPackId}/licences")
    public String showLicenceByChemistPack(Model model, @PathVariable(value = "ChemistPackId") Long ChemistPackId){
        model.addAttribute("licences",service.getLicenceByChemistPack(ChemistPackId));
        return "licence-list";
    }

    @GetMapping("/ChemistLicences/{ChemistPackId}/licences/{licenceId}")
    public String showLicenceDetails(Model model, @PathVariable("ChemistPackId") Long ChemistPackId,@PathVariable ("licenceId")Long licenceId)
    {
        Licence licence = service.fetchLicenceDetails(licenceId);
        model.addAttribute("licence",licence);
        return "licence-details";
    }

    @PostMapping("/licence/delete")
    public String removeLicence(@RequestParam(name = "licenceId")String licenceId){
        System.out.println(licenceId);
        Long id = Long.valueOf(licenceId);
        Long chemistPackId = service.fetchLicenceDetails(id).getPack().getId();
        Integer result = service.removeLicence(id,chemistPackId);
        if(result == -1) {
            return "error-page";
        }

        return "redirect:/ChemistLicences/"+chemistPackId+"/licences";
    }

}
