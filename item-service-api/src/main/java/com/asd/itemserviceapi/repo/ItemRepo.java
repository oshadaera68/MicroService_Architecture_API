package com.asd.itemserviceapi.repo;


import com.asd.itemserviceapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, String> {
}
