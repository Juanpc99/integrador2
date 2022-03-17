package com.lenguageconquers.dao;

import com.lenguageconquers.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AvatarDAO extends JpaRepository<Avatar, Long> {
}
