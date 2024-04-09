package com.fanta.newspriborzhavalyceum.database.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fanta.newspriborzhavalyceum.database.entity.EventPlace;

@Repository
public interface EventPlaceRepository extends JpaRepository<EventPlace, Long> {
}
