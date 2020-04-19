package com.vo;


import lombok.Data;

/**
 * 数据返回VO
 *
 * @author Clrvn
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
