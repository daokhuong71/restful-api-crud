package com.daoquangkhuong.demo.model.request;

import lombok.Data;

@Data
public class BaseFilter {
    private int pageIndex = 0;
    private int pageSize = 10;
}
