package com.get_and_food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get_and_food.application.CsvReaderService;
import com.get_and_food.controller.response.csvStoreResponse;

@RestController
public class CsvReaderController {

    @Autowired
    private CsvReaderService csvReaderService;

    @GetMapping("/read-csv")
    public String readCsv() {
        String csvFile = "C:\\Users\\82105\\Downloads\\경상북도 구미시_일반음식점 정보_20230801.csv";
        csvReaderService.readAndSave(csvFile);
        return "CSV 파일을 읽고 데이터베이스에 저장했습니다.";
    }
    
    @GetMapping("/mapsAll")
	public List<csvStoreResponse.SearchMaps> findAllStore() 
	{
	    return csvReaderService.searchForAllStore();
	}
}