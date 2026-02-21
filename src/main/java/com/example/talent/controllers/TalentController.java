package com.example.talent.controllers;

import com.example.talent.dtos.*;
import com.example.talent.services.DocumentService;
import com.example.talent.services.TalentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/talent")
public class TalentController {
    private final TalentService talentService;
    private final DocumentService documentService;

    public TalentController(TalentService talentService, DocumentService documentService) {
        this.talentService = talentService;
        this.documentService = documentService;
    }

    @GetMapping
    public ResponseEntity<List<TalentDTO>> getTalents() {
        return ResponseEntity.ok(talentService.getTalents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TalentDTO> getTalent(@PathVariable UUID id) {
        return ResponseEntity.of(talentService.findById(id));
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity<List<DocumentDTO>> getDocuments() {
        return ResponseEntity.ok(documentService.getDocuments());
    }

    @GetMapping("/{id}/documents/{documentId}")
    public ResponseEntity<DocumentDTO> getDocument(@PathVariable UUID id, @PathVariable UUID documentId) {
        if (talentService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return documentService.findById(documentId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
