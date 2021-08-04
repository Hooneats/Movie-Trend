package com.example.project.service.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JsonSearchVo {

    private int page;
    private List<Map> results;
    private int total_pages;
    private Long total_results;

}
