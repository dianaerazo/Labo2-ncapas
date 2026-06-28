package org.example.labo2hogwarts.controller;

import lombok.AllArgsConstructor;
import org.example.labo2hogwarts.domain.entity.Wizard;
import org.example.labo2hogwarts.service.impl.WizardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {
    private final WizardServiceImpl wizardService;

    @PostMapping
    public ResponseEntity<Wizard> createWizard(
            @RequestBody Wizard wizard
    ) {

        wizardService.createWizard(wizard);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wizard);
    }

    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getAllWizards());
    }

    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getDeatheaters());
    }

    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<Wizard> getWizardByPatronus(
            @PathVariable String patronus
    ) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.getWizardByPatronus(patronus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(
            @PathVariable UUID id,
            @RequestBody Wizard wizard
    ) {

        wizardService.updateWizard(id, wizard);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizard);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Wizard> deleteWizard(
            @PathVariable UUID id
    ) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(wizardService.deleteWizard(id));
    }
}
