package com.clientui.controller;


import com.clientui.dao.RestaurantDao;
import com.clientui.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
  //  @Autowired
    //private RestaurantProxy restaurantProxy ;
    @Autowired
    RestaurantDao restaurantsDao;
    @RequestMapping("/")
    public String accueil(Model model) {
        return "index";
    }
    @RequestMapping("/restaurants")
    public String restaurant(Model model) {
        List<Restaurant> restaurants = restaurantsDao.findAll();

        model.addAttribute("notorder", true);
        model.addAttribute("restaurants", restaurants);
        return "Restaurant";
    }
    @RequestMapping("/classements")
    public String classements(Model model) {
        List<Restaurant> restaurants =  restaurantsDao.findAll(new Sort(Sort.Direction.DESC,"moyen"));
        model.addAttribute("isorder", true);
        model.addAttribute("restaurants", restaurants);
        return "Restaurant";
    }
    @RequestMapping("/restaurants/{id}")
    public String RestaurantDetail(@PathVariable int id, Model model){
        Restaurant restaurant = restaurantsDao.findById(id).get();
        model.addAttribute("restaurant", restaurant);
        return "DetailRestaurant";
    }
    @GetMapping("/getOnRestaurantt/{id}")
    @ResponseBody
    public Restaurant getOnRestaurantt(@PathVariable int id){

        return restaurantsDao.findById(id).get();
    }
    @PostMapping("/addnote")
    public String addCommande(  Restaurant restaurant){
        Optional<Restaurant> sr=restaurantsDao.findById(restaurant.getId());
        sr.get().calculMoyen(restaurant.getQnouriture(),restaurant.getQsalle(),restaurant.getQservice());
        restaurantsDao.save(sr.get());

        return "redirect:/restaurants/"+restaurant.getId();

    }
}