package com.info.repository;

import com.info.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Integer> {
}
