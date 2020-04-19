package com.pojo;


import lombok.Data;

import java.util.Objects;

/**
 * @author Clrvn
 * @description 属性
 * @date 2020/4/18 22:30
 */
@Data
public class Prop {

    /**
     * 排序
     */
    private Integer order;
    /**
     * 字段名
     */
    private String name;

    /**
     * 类型 1、数字 2、文本
     */
    private Integer type;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 范围开始
     */
    private Integer scopeStart;

    /**
     * 范围结束
     */
    private Integer scopeEnd;

    /**
     * 长度开始
     */
    private Integer lengthStart;

    /**
     * 长度结束
     */
    private Integer lengthEnd;

    /**
     * 单位
     */
    private String unit;

    /**
     * 参数
     */
    private String param;


    /**
     * 值
     */
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prop prop = (Prop) o;
        return Objects.equals(name, prop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
