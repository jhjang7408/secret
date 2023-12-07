package com.secret.dessertmap.controller;

import com.secret.dessertmap.entity.DessertEntity;
import com.secret.dessertmap.service.DessertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class DessertController {

    private final DessertService dessertService;

/*
    @GetMapping("/dessert/save")
    public String dessertsaveForm(){
        return "dessertsave";
    }
*/
    @PostMapping("/dessert/save")
    public String dessertsave(@ModelAttribute DessertEntity dessertEntity){

        dessertService.save(dessertEntity);

        return "redirect:/shop/" + dessertEntity.getShopId();
    }



}
