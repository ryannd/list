package com.ryannd.list_api.service;

import com.ryannd.list_api.dto.EntryDto;
import com.ryannd.list_api.entity.Entry;
import com.ryannd.list_api.entity.Media;
import com.ryannd.list_api.entity.User;
import com.ryannd.list_api.repository.EntryRepository;
import com.ryannd.list_api.utils.EntryMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    @Autowired private MediaService mediaService;
    @Autowired private UserService userService;
    @Autowired EntryMapper mapper;

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

    public Entry getEntry(String entryId) {
        if (entryRepository.existsById(entryId)) {
            return entryRepository.findById(entryId).get();
        } else {
            throw new RuntimeException("ENTRY NOT FOUND");
        }
    }

    public Entry updateEntry(EntryDto entry, String entryId) {
        Optional<Entry> entryQuery = entryRepository.findById(entryId);

        if (entryQuery.isPresent()) {
            Entry entryToUpdate = entryQuery.get();
            mapper.updateEntryFromDto(entry, entryToUpdate);
            entryRepository.save(entryToUpdate);
            return entryToUpdate;
        } else {
            throw new RuntimeException("ENTRY NOT FOUND");
        }
    }

    public void deleteEntry(String entryId) {
        if (entryRepository.existsById(entryId)) {
            User user = userService.getCurrentUser();
            Entry entryToDelete =
                    user.getEntries().stream()
                            .filter(entry -> entry.getId().equals(entryId))
                            .findFirst()
                            .orElseThrow(
                                    () ->
                                            new RuntimeException(
                                                    "Entry not found with ID: " + entryId));
            user.getEntries().remove(entryToDelete);
            userService.updateUser(user);
        } else {
            throw new RuntimeException("ENTRY NOT FOUND");
        }
    }
}
