package com.daffarez.markdown_to_html_api.controller;

import com.daffarez.markdown_to_html_api.model.MarkdownRequest;
import com.daffarez.markdown_to_html_api.service.MarkdownService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/convert")
public class ConverterController {
    private final MarkdownService markdownService;

    public ConverterController(MarkdownService markdownService) {
        this.markdownService = markdownService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> convert(@RequestBody MarkdownRequest request) {
        String html = markdownService.convertToHtml(request.getMarkdown());
        return ResponseEntity.ok(Map.of("html", html));
    }
}
