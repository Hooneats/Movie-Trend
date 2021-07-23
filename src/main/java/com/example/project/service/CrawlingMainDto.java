package com.example.project.service;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CrawlingMainDto {
    private int page;
    private List<Map> results;
    private int total_pages;
    private int total_results;
}
