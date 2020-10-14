package com.samsungsds.eshop.recommend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/recommends")
public class RecommendController {
  private final RecommendService recommendService;

  public RecommendController(final RecommendService recommendService) {
    this.recommendService = recommendService;
  }

  @GetMapping
  public ResponseEntity<Recommendations> recommendProducts() {
    return ResponseEntity.ok(recommendService.recommendProducts());
  }
}
