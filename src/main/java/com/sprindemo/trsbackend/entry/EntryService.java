package com.sprindemo.trsbackend.entry;

import com.sprindemo.trsbackend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Entry> getEntry(Long id){
        return entryRepository.findById(id);
    }

    @Transactional
    public void updateEntry(Long id, String subCode, String description, Integer time) {
        Optional<Entry> test = getEntry(id);
        Entry toUpdate =  test.get();
        toUpdate.setSubCode(subCode);
        toUpdate.setDescription(description);
        toUpdate.setTime(time);

    }

    public void deleteEntry(Entry toDelete) {
        entryRepository.delete(toDelete);
    }
}
