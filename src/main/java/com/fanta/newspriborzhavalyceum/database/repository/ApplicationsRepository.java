package com.fanta.newspriborzhavalyceum.database.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fanta.newspriborzhavalyceum.database.entity.Applications;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
}
