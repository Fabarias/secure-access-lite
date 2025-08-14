package com.secureaccesslite.model;

import java.util.List;

public class DisplacementPattern {

    private String patternId;
    private String description;
    private List<String> keyPoints;

    public DisplacementPattern(String patternId, String description, List<String> keyPoints) {
        this.patternId = patternId;
        this.description = description;
        this.keyPoints = keyPoints;
    }

    public String getPatternId() {
        return patternId;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getKeyPoints() {
        return keyPoints;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyPoints(List<String> keyPoints) {
        this.keyPoints = keyPoints;
    }
}
