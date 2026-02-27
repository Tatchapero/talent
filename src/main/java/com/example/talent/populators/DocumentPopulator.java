package com.example.talent.populators;

import com.example.talent.dtos.DocumentDTO;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DocumentPopulator {
    public static List<DocumentDTO> populateDocuments() {
        List<String> documentNames = Arrays.asList(
                "Thomas_Atchapero_Ansøgning_Tech_Chapter.pdf",
                "Thomas_Atchapero_CV.pdf"
        );

        return documentNames.stream().map((d) -> DocumentDTO.builder()
                .id(UUID.randomUUID())
                .name(d)
                .content(encodeDocument(d))
                .build())
                .collect(Collectors.toList());
    }

    private static String encodeDocument(String name) {
        ClassPathResource resource = new ClassPathResource("documents/" + name);

        try {
            byte[] bytes = resource.getInputStream().readAllBytes();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
