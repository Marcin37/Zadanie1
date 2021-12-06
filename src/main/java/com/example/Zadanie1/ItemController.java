package com.example.Zadanie1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/addItem")
    public Item addItem(@RequestBody ItemRequest itemRequest) {
       return itemService.addItem(itemRequest);
    }

    @GetMapping("/getItem/{id}")
    public Item getItem(@PathVariable("id") UUID id) {
        return itemService.getItem(id);
    }


}
