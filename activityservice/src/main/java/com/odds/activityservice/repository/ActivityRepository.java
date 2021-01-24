package com.odds.activityservice.repository;

import com.odds.activityservice.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query("select a from Activity a where a.createdBy = ?1")
    public List<Activity> findActivityWithName(String name);

    public List<Activity> findAllByCreatedBy(String user);
}
