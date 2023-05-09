package com.mauricio.cardapio.controller;


import com.mauricio.cardapio.food.Food;
import com.mauricio.cardapio.food.FoodRepository;
import com.mauricio.cardapio.food.FoodRequestDTO;
import com.mauricio.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // indentificando para o Spring que é um arquivo de controle
@RequestMapping("food") // endPoint food criado
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){

        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping // indicando um metodo para o Spring
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;

    }
}
