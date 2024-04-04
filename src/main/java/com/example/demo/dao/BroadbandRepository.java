package com.example.demo.dao;
import com.example.demo.entity.Broadband;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadbandRepository extends JpaRepository<Broadband, Integer> {
}