package net.lliira.game.campaign.common.model.dnd;

import java.util.List;
import java.util.Map;

public class Race {
    private static class AgeRange {
        private int adulthood;
        private int venerable;
        private int max;
    }

    private static class Names {
        private List<String> childNames;
        private List<String> maleNames;
        private List<String> femaleNames;
        private List<String> familyNames;
    }

    private String label;
    private String parentRace;
    private AgeRange ageRange;
    private Names names;
    private Map<Ability, Integer> abilityIncreases;
    private List<Alignment> alignments;
    private Map<SpeedType, Integer> speeds;
    private List<Language> languages;

    public String getLabel() {
        return label;
    }

    public String getParentRace() {
        return parentRace;
    }

    public AgeRange getAgeRange() {
        return ageRange;
    }

    public Names getNames() {
        return names;
    }

    public Map<Ability, Integer> getAbilityIncreases() {
        return abilityIncreases;
    }

    public List<Alignment> getAlignments() {
        return alignments;
    }

    public Map<SpeedType, Integer> getSpeeds() {
        return speeds;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
