package com.secret.dessertmap.controller;

import com.secret.dessertmap.entity.ShopEntity;
import com.secret.dessertmap.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor    // final 같은 생성자를 자동으로 생성해줌
public class ShopController {

    private final ShopService shopService;

    @GetMapping("/shop")
    public String ShopList(Model model){
        List<ShopEntity> shopList = shopService.findAll();
        model.addAttribute("shopList", shopList);

        return "shoplist";
    }



    @GetMapping("/shop/save")
    public String shopsaveForm(){
        return "shopsave";
    }

    @PostMapping("/shop/save")
    public String shopsave(@ModelAttribute ShopEntity shopEntity, HttpSession session){

        shopService.save(shopEntity);

        return "redirect:/shop";
    }


    @GetMapping("/shop/{shopId}")
    public String shopdetail(@PathVariable int shopId, Model model){
        ShopEntity shopEntity = shopService.findById(shopId);

        model.addAttribute("shopdetail", shopEntity);

        return "shopdetail";
    }

}
