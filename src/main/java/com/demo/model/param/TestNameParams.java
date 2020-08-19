package com.demo.model.param;

import lombok.Data;

@Data
public class TestNameParams {
    private String name;


    /**
     * 当前页
     */
    private String pageNumber;
    /**
     * 一页大小
     */
    private String pageSize;
}
