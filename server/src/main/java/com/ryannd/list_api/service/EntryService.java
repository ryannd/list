package com.ryannd.list_api.service;

import com.ryannd.list_api.dto.EntryDto;
import com.ryannd.list_api.entity.Entry;
import com.ryannd.list_api.entity.Media;
import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    @Autowired private MediaService mediaService;
    @Autowired private UserService userService;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry addEntryToList(EntryDto entry) {
        Media mediaToAdd =
                mediaService.getMedia(
                        entry.getMediaRequest().getId(),
                        entry.getMediaRequest().getSource(),
                        entry.getMediaRequest().getType());
        Entry newEntry;
        User currentUser = userService.getCurrentUser();

        if (mediaToAdd.getType().equals("tv")) {
            newEntry =
                    new Entry(
                            mediaToAdd,
                            Entry.Status.valueOf(entry.getStatus()),
                            entry.getRating(),
                            entry.getSeasonProgress(),
                            entry.getEpisodeProgress());
        } else {
            newEntry =
                    new Entry(
                            mediaToAdd, Entry.Status.valueOf(entry.getStatus()), entry.getRating());
        }

        entryRepository.save(newEntry);
        currentUser.getEntries().add(newEntry);
        userService.updateUser(currentUser);

        return newEntry;
    }
}
