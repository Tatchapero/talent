package com.example.talent.services;

import com.example.talent.dtos.TalentDTO;
import com.example.talent.populators.TalentPopulator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TalentService {
    List<TalentDTO> talents;

    public TalentService () {
        this.talents = TalentPopulator.populateTalents();
    }

    public List<TalentDTO> getTalents() {
        return talents;
    }

    public Optional<TalentDTO> findById(UUID uuid) {
        return talents.stream()
                .filter(t -> Objects.equals(t.getId(), uuid))
                .findFirst();
    }
}
