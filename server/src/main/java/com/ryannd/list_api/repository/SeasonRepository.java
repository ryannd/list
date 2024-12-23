package com.ryannd.list_api.repository;

import com.ryannd.list_api.entity.Season;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<Season, String> {}
