package com.summer.cat.enums;

public enum EnumSaciAnnexType {
    MENHARA("menhara");

    private EnumSaciAnnexType(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
