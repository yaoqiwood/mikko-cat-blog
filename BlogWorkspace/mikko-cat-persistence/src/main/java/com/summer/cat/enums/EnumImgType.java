package com.summer.cat.enums;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum EnumImgType {
    /**
     * JPG("jpg"), PNG("png"), GIF("gif"), WEBP("webp");
     */
    JPG("jpg"), PNG("png"), GIF("gif"), WEBP("webp");

    private String name;

    EnumImgType(String name) {
        this.name = name;
    }

    public static Stream<EnumImgType> stream() {
        return Stream.of(EnumImgType.values());
    }

}
