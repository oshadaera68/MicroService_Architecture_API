package com.asd.addressserviceapi.repo;

import com.asd.addressserviceapi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AddressRepo extends JpaRepository<Address, String> {
}
