package com.daoquangkhuong.demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilterRequest extends BaseFilter {
    private String name;
    private String address;
}
