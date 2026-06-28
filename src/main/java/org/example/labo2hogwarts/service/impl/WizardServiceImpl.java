package org.example.labo2hogwarts.service.impl;

import org.example.labo2hogwarts.domain.entity.Wizard;
import org.example.labo2hogwarts.repository.WizardRepository;
import lombok.RequiredArgsConstructor;
import org.example.labo2hogwarts.service.WizardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Override
    public void createWizard(Wizard wizard) {
        wizardRepository.save(wizard);
    }

    @Override
    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    @Override
    public List<Wizard> getDeatheaters() {
        return wizardRepository.getWizardByIsDeatheater(true);
    }

    @Override
    public Wizard getWizardByPatronus(String patronus) {
        return wizardRepository.getWizardByPatronus(patronus);
    }

    @Override
    public void updateWizard(UUID id, Wizard wizard) {

        Wizard existingWizard = wizardRepository.getWizardById(id);

        existingWizard.setName(wizard.getName());
        existingWizard.setHouse(wizard.getHouse());
        existingWizard.setPatronus(wizard.getPatronus());
        existingWizard.setIsDeatheater(wizard.getIsDeatheater());

        wizardRepository.save(existingWizard);
    }

    @Override
    public Wizard deleteWizard(UUID id) {

        Wizard existingWizard = wizardRepository.getWizardById(id);

        wizardRepository.deleteById(id);

        return existingWizard;
    }
}