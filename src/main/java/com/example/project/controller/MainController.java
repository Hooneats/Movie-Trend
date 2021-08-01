package com.example.project.controller;

import com.example.project.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private String my_id = "160f05c35f34aef167fabe796efb2a8e";


    //original_title, poster_path, vote_average, overview, release_date, title, original_language , id, backdrop_path
    @GetMapping(value = "/")
    public String crawlingMainDto(Model model) {
        List<MovieVo> movieVoList = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/trending/movie/day?api_key=" + my_id;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CrawlingMainVo craw = objectMapper.readValue(new URL(url), CrawlingMainVo.class);
            for (Map s : craw.getResults()) {
                MovieVo movieVo = new MovieVo();
                for (Object o : s.keySet()) {
                    if ("id".equals(o)) {
                        movieVo.setId(Long.parseLong(String.valueOf(s.get(o))));
                    } else if ("original_title".equals(o)) {
                        movieVo.setOriginal_title(String.valueOf(s.get(o)));
                    } else if ("title".equals(o)) {
                        movieVo.setTitle(String.valueOf(s.get(o)));
                    } else if ("original_language".equals(o)) {
                        movieVo.setOriginal_language(String.valueOf(s.get(o)));
                    } else if ("release_date".equals(o)) {
                        if (String.valueOf(s.get(o)).length() == 0) {
                            movieVo.setRelease_date(null);
                        } else {
                            movieVo.setRelease_date(Date.valueOf(String.valueOf(s.get(o))));
                        }
                    } else if ("vote_average".equals(o)) {
                        movieVo.setVote_average(String.valueOf(s.get(o)));
                    } else if ("overview".equals(o)) {
                        movieVo.setOverview(String.valueOf(s.get(o)));
                    } else if ("poster_path".equals(o)) {
                        movieVo.setPoster_path(String.valueOf(s.get(o)));
                    } else if ("backdrop_path".equals(o)) {
                        movieVo.setBackdrop_path(String.valueOf(s.get(o)));
                    }
                }
                movieVoList.add(movieVo);
            }
            model.addAttribute("movieList", movieVoList);
            return "index";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/search")
    public String crawlingSearchDto(@RequestParam(value = "query", required = false) String query,
                                    @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        if (query.trim().isEmpty()) {
            return "redirect:/";
        }
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + my_id + "&query=" + query + "&page=" + page;
//        System.out.println(url);;
        ObjectMapper objectMapper = new ObjectMapper();
        List<MovieVo> resultList = new ArrayList<>();
        try {
            CrawlingSearchVo crawlingSearchVo = objectMapper.readValue(new URL(url), CrawlingSearchVo.class);
            for (Map s : crawlingSearchVo.getResults()) {
                MovieVo movieVo = new MovieVo();
                for (Object o : s.keySet()) {
                    if ("id".equals(o)) {
                        movieVo.setId(Long.parseLong(String.valueOf(s.get(o))));
                    } else if ("original_title".equals(o)) {
                        movieVo.setOriginal_title(String.valueOf(s.get(o)));
                    } else if ("title".equals(o)) {
                        movieVo.setTitle(String.valueOf(s.get(o)));
                    } else if ("original_language".equals(o)) {
                        movieVo.setOriginal_language(String.valueOf(s.get(o)));
                    } else if ("release_date".equals(o)) {
                        if (String.valueOf(s.get(o)).length() == 0) {
                            movieVo.setRelease_date(null);
                        } else {
                            movieVo.setRelease_date(Date.valueOf(String.valueOf(s.get(o))));
                        }
                    } else if ("vote_average".equals(o)) {
                        movieVo.setVote_average(String.valueOf(s.get(o)));
                    } else if ("overview".equals(o)) {
                        movieVo.setOverview(String.valueOf(s.get(o)));
                    } else if ("poster_path".equals(o)) {
                        movieVo.setPoster_path(String.valueOf(s.get(o)));
                    } else if ("backdrop_path".equals(o)) {
                        movieVo.setBackdrop_path(String.valueOf(s.get(o)));
                    }
                }
                resultList.add(movieVo);
            }
            SearchResultPageNationVo searchResultPageNationVo = new SearchResultPageNationVo(crawlingSearchVo.getPage(),
                    crawlingSearchVo.getTotal_pages(), crawlingSearchVo.getTotal_results(),query);
            int total = crawlingSearchVo.getTotal_pages() / 5;
            if (crawlingSearchVo.getTotal_pages() % 5 != 0) {
                total++;
            }
            int startNum = 1;
            int endNum = crawlingSearchVo.getTotal_pages();
            if (endNum > 10) {
                if (page < 6) {
                    startNum = 1;
                    endNum = 9;
                } else {
                    startNum = Math.max(1, page - 4);
                    endNum = Math.min(page + 4, crawlingSearchVo.getTotal_pages());
                }
            }

            model.addAttribute("movieList", resultList);
            model.addAttribute("searchPagiNation", searchResultPageNationVo);
            model.addAttribute("startNum", startNum);
            model.addAttribute("endNum", endNum);
            return "index";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
