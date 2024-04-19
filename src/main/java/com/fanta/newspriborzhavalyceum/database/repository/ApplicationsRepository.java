package com.fanta.newspriborzhavalyceum.database.repository;

import com.fanta.newspriborzhavalyceum.database.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
}
