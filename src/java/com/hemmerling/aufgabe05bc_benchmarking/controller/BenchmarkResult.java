/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe05bc_benchmarking.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class BenchmarkResult {

    Map<String, List<Long>> benchmarkingResults = new HashMap<String, List<Long>>();
    List list;

    private static BenchmarkResult instance = null;

    protected BenchmarkResult() {
        // Exists only to defeat instantiation.
    }

    public static BenchmarkResult getInstance() {
        if (instance == null) {
            instance = new BenchmarkResult();
        }
        return instance;
    }

    public Map<String, List<Long>> getBenchmarkingResults() {
        return benchmarkingResults;
    }

    public void addBenchmarkingResults(String key, Long value) {
        if (benchmarkingResults.containsKey(key)) {
            List list = benchmarkingResults.get(key);
            if (list == null) {
                list = new LinkedList();
            }
            list.add(value);
            benchmarkingResults.replace(key, list);
        } else {
            list = new LinkedList();
            list.add(value);
            benchmarkingResults.put(key, list);
        }
    }
}
