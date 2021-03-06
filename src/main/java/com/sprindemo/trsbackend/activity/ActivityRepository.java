package com.sprindemo.trsbackend.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {
    Activity findByCode(String code);
}
