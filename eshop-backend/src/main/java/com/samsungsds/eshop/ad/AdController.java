package com.samsungsds.eshop.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ads")
public class AdController {
    private Logger logger = LoggerFactory.getLogger(AdController.class);
    // private static final ImmutableListMultimap<String, Ad> adsMap = createAdsMap();
    private final AdRepository adRepository;
    private static final Random random = new Random();
    private static final int MAX_ADS_TO_SERVE = 2;

    public AdController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Ad>> getRandomAds() {
        logger.info("getRandomAds");
        List<Ad> ads = new ArrayList<>(MAX_ADS_TO_SERVE);
        List<Ad> allAds = Lists.newArrayList(adRepository.findAll());
        for(int i = 0; i < MAX_ADS_TO_SERVE; i++) {
            ads.add(Iterables.get(allAds, random.nextInt(allAds.size())));
        }
        logger.info(ads.toString());
        return ResponseEntity.ok(ads);
    }

    @GetMapping(value="/{categories}")
    @ResponseBody
    public ResponseEntity<List<Ad>> getAdsByCategory(@PathVariable String[] categories) {
        logger.info("getAdsByCategory {}", Arrays.toString(categories));
        List<Ad> ads = Lists.newArrayList(adRepository.findByCategoryIn(categories));
        logger.info(ads.toString());
        return ResponseEntity.ok(ads);
    }
}
