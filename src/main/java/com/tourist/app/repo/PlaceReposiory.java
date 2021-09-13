package com.tourist.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourist.app.model.places;
@Repository
public interface PlaceReposiory extends JpaRepository<places, Integer> {

}
