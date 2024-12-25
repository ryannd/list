package com.ryannd.list_api.repository;

import com.ryannd.list_api.entity.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, String> {}
