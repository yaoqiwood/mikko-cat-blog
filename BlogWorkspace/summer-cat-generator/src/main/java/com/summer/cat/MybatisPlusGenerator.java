package com.summer.cat;

import com.summer.cat.resources.generator.MybatisPlusGeneratorUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisPlusGenerator {

    /**
     * 执行生成
     * @param args
     */
    public static void main(String[] args) {
        MybatisPlusGeneratorUtil.executeGenerate();

    }

}
