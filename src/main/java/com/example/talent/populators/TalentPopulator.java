package com.example.talent.populators;

import com.example.talent.dtos.TalentDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

public class TalentPopulator {
    public static List<TalentDTO> populateTalents() {
        URI github;
        URI linkedin;

        try {
            github = new URI("https://github.com/Tatchapero");
            linkedin = new URI("https://www.linkedin.com/in/thomas-atchapero/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        TalentDTO talent = TalentDTO.builder()
                .id(UUID.randomUUID())
                .name("Thomas Atchapero")
                .title("Datamatiker")
                .profileText("Datamatiker studerende med interesse for Full-Stack udvikling, DevOps og " +
                        "kvalitetssikring. ISTQB Foundation Test certificeret, med over 8 års erfaring i manuel og " +
                        "automatiseret test, CI/CD og cloud-baseret infrastruktur. Motiveres af at skabe stabile " +
                        "løsninger gennem automatisering, kvalitetssikring og effektiv DevOps-praksis."
                )
                .email("t.atchapero@gmail.com")
                .phone("(+45)53354177")
                .city("Farum")
                .country("Danmark")
                .github(github)
                .linkedin(linkedin)
                .build();

        return List.of(talent);
    }
}
