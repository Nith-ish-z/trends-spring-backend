package com.ecom.trends.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MarginRequest {
    public List<Long> id;
    public List<Long> c_id;
    public List<Long> sc_id;
}