package org.example.labo2hogwarts.service;

import org.example.labo2hogwarts.domain.entity.Wizard;
import org.example.labo2hogwarts.repository.WizardRepository;
import org.example.labo2hogwarts.service.impl.WizardServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WizardServiceImplTest {

    @Mock
    private WizardRepository wizardRepository;

    @InjectMocks
    private WizardServiceImpl wizardService;

    private Wizard wizard;
    private UUID wizardId;

    @BeforeEach
    void setUp() {

        wizardId = UUID.randomUUID();

        wizard = Wizard.builder()
                .id(wizardId)
                .name("Harry Potter")
                .house("Gryffindor")
                .patronus("Stag")
                .isDeatheater(false)
                .build();
    }

    @Test
    void createWizard_shouldSaveWizard() {

        wizardService.createWizard(wizard);

        verify(wizardRepository).save(wizard);
    }

    @Test
    void getAllWizards_shouldReturnList() {

        when(wizardRepository.findAll())
                .thenReturn(List.of(wizard));

        List<Wizard> result = wizardService.getAllWizards();

        assertThat(result).hasSize(1);
        assertThat(result.getFirst().getName()).isEqualTo("Harry Potter");
    }

    @Test
    void deleteWizard_shouldDeleteWizard() {

        wizardService.deleteWizard(wizardId);

        verify(wizardRepository).deleteById(wizardId);
    }

    @Test
    void updateWizard_shouldUpdateWizard() {

        Wizard updatedWizard = Wizard.builder()
                .name("Hermione Granger")
                .house("Gryffindor")
                .patronus("Otter")
                .isDeatheater(false)
                .build();

        when(wizardRepository.getWizardById(wizardId))
                .thenReturn(wizard);

        wizardService.updateWizard(wizardId, updatedWizard);

        assertThat(wizard.getName()).isEqualTo("Hermione Granger");
        assertThat(wizard.getPatronus()).isEqualTo("Otter");

        verify(wizardRepository).save(wizard);
    }
}