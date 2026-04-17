package br.com.carstore.controller;

import br.com.carstore.service.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import br.com.carstore.dto.CarDTO;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CarServiceImpl carService;

    public HomeController(CarServiceImpl service){
        this.carService = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @PostMapping("/cars")
    public String createCar(CarDTO carDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index"; // Em caso de erro, retorna ao formulário com as mensagens
        }

        carService.save(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/cars")
    public String getCars(Model model){
        List<CarDTO> allCars =  carService.findAll();
        model.addAttribute("cars", allCars);
        return "dashboard";
    }
}
