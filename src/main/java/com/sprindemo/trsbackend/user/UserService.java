package com.sprindemo.trsbackend.user;

import com.sprindemo.trsbackend.entry.Entry;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String name){
        return userRepository.findByUserName(name);
    }

    @Autowired
    private EntityManager em;

    public List<Entry> getUserEntries(String name, String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate date = LocalDate.parse(dateString,formatter);
//
//        Session session = em.unwrap(Session.class);
//        Filter filter = session.enableFilter("dateFilter");
//        filter.setParameter("entryMonth",date.withDayOfMonth(1));
//        List<Entry> temp  = em.createQuery("select p from Entry ")
        List<Entry> temp = this.getUser(name).getEntries();
        List<Entry> toReturn = new ArrayList<>();
        for (Entry entry: temp
             ) {
            if(entry.getDate().getMonth() == date.getMonth()) toReturn.add(entry);
        }

        return toReturn;
//        session.disableFilter("dateFilter");
    }
}
