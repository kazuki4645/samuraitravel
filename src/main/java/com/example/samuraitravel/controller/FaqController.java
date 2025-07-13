package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.samuraitravel.entity.Faq;
import com.example.samuraitravel.service.FaqService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FaqController {
	private final FaqService faqService;

    @GetMapping("/faqs")
    public String index(
            @RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "0") int page,
            Model model) {

    	Pageable pageable = PageRequest.of(page, 10);
        Page<Faq> faqs;

        if (keyword != null && !keyword.isEmpty()) {
            faqs = faqService.findAllFaqs(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            faqs = faqService.getAllFaqs(pageable);
        }

        model.addAttribute("faqs", faqs);

        return "user/faq";
    }
}
