package com.calculator.app.controller;

import com.calculator.app.entity.Country;
import com.calculator.app.entity.Earning;
import com.calculator.app.service.EarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/earnings")
public class EarningController {

    @Autowired
    private EarningService earningService;

    @PostMapping("/{earningPerDay}")
    public Earning getEarnedMoney (@RequestBody Country country, @PathVariable double earningPerDay) throws IOException {
        Earning earning = earningService.getEarnedMoney(country, earningPerDay);
        return earning;
    }
}
