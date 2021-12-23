package com.summer.cat.enums;

public enum EnumSaciAnnexType {
    MENHARA("menhara"), TEMP_UPLOAD_IMG("temp_upload_img");

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
