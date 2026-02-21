package com.example.talent.services;

import com.example.talent.dtos.DocumentDTO;
import com.example.talent.populators.DocumentPopulator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {
    List<DocumentDTO> documents;

    public DocumentService() {
        this.documents = DocumentPopulator.populateDocuments();
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public Optional<DocumentDTO> findById(UUID uuid) {
        return documents.stream()
                .filter(d -> Objects.equals(d.getId(), uuid))
                .findFirst();
    }
}
