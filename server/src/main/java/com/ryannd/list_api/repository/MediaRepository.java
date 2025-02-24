package com.ryannd.list_api.repository;

import com.ryannd.list_api.entity.Media;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MediaRepository extends CrudRepository<Media, String> {
    @Query(
            value = "SELECT * FROM medias WHERE source_id=?1 AND source=?2 AND type=?3",
            nativeQuery = true)
    public Optional<Media> find(String sourceId, String source, String type);
}
