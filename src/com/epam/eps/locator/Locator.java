package com.epam.eps.locator;

import com.epam.eps.RiskGroup;

import java.util.Map;

public interface Locator {
    Map<RiskGroup, Integer> find();
}
