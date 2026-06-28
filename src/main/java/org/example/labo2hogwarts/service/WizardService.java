package org.example.labo2hogwarts.service;

import org.example.labo2hogwarts.domain.entity.Wizard;

import java.util.List;
import java.util.UUID;

public interface WizardService {
    void createWizard(Wizard wizard);

    List<Wizard> getAllWizards();
    List<Wizard> getDeatheaters();

    Wizard getWizardByPatronus(String patronus);

    void updateWizard(UUID id, Wizard wizard);

    Wizard deleteWizard(UUID id);
}
