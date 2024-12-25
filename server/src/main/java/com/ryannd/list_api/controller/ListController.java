package com.ryannd.list_api.controller;

import com.ryannd.list_api.dto.EntryDto;
import com.ryannd.list_api.entity.Entry;
import com.ryannd.list_api.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/list")
public class ListController {
    @Autowired private EntryService entryService;

    @PostMapping("/add")
    public Entry addToList(@RequestBody EntryDto entry) {
        return entryService.addEntryToList(entry);
    }
}
