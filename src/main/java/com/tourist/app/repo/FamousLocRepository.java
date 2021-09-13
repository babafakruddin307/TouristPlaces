package com.tourist.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourist.app.model.famousLoc;
@Repository
public interface FamousLocRepository extends JpaRepository<famousLoc, Integer> {

}
