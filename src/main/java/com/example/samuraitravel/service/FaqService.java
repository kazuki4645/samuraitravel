package com.example.samuraitravel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Faq;
import com.example.samuraitravel.repository.FaqRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FaqService {
	private final FaqRepository faqRepository;
	
	// 全FAQデータをページ付きで取得
	public Page<Faq> getAllFaqs(Pageable pageable) {
		return faqRepository.findAll(pageable);
	}
	
	// 質問文にキーワードが含まれているFAQを検索（部分一致）
	public Page<Faq> findAllFaqs(String keyword, Pageable pageable) {
		return faqRepository.findByQuestionContaining(keyword, pageable);
	}
}
