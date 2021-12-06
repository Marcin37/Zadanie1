package com.example.Zadanie1;


import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ItemService {
    private static final Map<UUID, Item> ITEM_MAP = new HashMap<>();


    public Item addItem(ItemRequest itemRequest) {
        UUID uuid = UUID.randomUUID();
        Item item = new Item(uuid, itemRequest.getName());
        ITEM_MAP.put(uuid, item);
        return item;
    }

    public Item getItem(UUID uuid) {
        return ITEM_MAP.get(uuid);
    }
}
