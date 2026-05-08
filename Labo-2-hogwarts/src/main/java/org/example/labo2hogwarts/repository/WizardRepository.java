package org.example.labo2hogwarts.repository;

import org.example.labo2hogwarts.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    List<Wizard> getWizardByIsDeatheater(Boolean isDeatheater);

    Wizard getWizardByPatronus(String patronus);

    Wizard getWizardById(UUID id);

}
