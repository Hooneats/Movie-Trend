package com.example.project.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchResultPageNationVo {
    private int currentPage;
    private int total_pages;
    private Long total_results;
    private String searchContent;
}
