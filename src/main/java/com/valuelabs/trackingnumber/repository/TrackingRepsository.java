package com.valuelabs.trackingnumber.repository;

import com.valuelabs.trackingnumber.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepsository extends JpaRepository<Tracking,String> {

}
