package com.example.talent.populators;

import com.example.talent.dtos.DocumentDTO;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

public class DocumentPopulator {
    public static List<DocumentDTO> populateDocuments() {
        String name = "Resume.pdf";
        ClassPathResource resource = new ClassPathResource("documents/" + name);
        String base64;

        try {
            byte[] bytes = resource.getInputStream().readAllBytes();
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DocumentDTO document = DocumentDTO.builder()
                .id(UUID.randomUUID())
                .name(name)
                .content(base64)
                .build();

        return List.of(document);
    }
}
