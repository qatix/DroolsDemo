package com.qatix.droolsdemo.repositoty;

import com.qatix.droolsdemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
