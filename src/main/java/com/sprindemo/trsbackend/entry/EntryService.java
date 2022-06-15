package com.sprindemo.trsbackend.entry;

import com.sprindemo.trsbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;
    @Autowired
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public List<Entry> getUserEntries(User user){
        return entryRepository.findByUser(user);
    }
}
