package com.example.Zadanie1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {

    private ItemService itemService;

    @BeforeEach
    void setUp(){
        itemService=new ItemService();
    }

    @Test
    void addItem_existentName_expectGivenName() {
        String name="test";
        Item item=itemService.addItem(new ItemRequest(name));
        Item result=itemService.getItem(item.getId());

        assertEquals(name,result.getName());
    }

    @Test
    void getItem_nonExistentUuid_expectNull() {
        Item result=itemService.getItem(UUID.randomUUID());
        assertNull(result);
    }

    @Test
    void getItem_existentUuid_expectSuccess() {
        Item item=itemService.addItem(new ItemRequest("test"));
        Item result=itemService.getItem(item.getId());

        assertNotNull(item);
        assertEquals(item,result);
    }
}