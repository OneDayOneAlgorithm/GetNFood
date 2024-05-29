package com.get_and_food.application;

import com.get_and_food.controller.request.CsvStoreRequest;
import com.get_and_food.controller.response.StoreResponse;
import com.get_and_food.controller.response.csvStoreResponse;
import com.get_and_food.domain.model.*;
import com.get_and_food.domain.repository.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class CsvReaderService {

    @Autowired
    private CsvDateRepository csvDateRepository;
    
    public void readAndSave(String csvFile) 
    {
        try (FileInputStream fileInputStream = new FileInputStream(csvFile);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             CSVReader reader = new CSVReader(bufferedReader)) {

            List<String[]> lines = reader.readAll();

            // CSV 파일의 각 행 데이터 출력 및 저장
            for (int i = 1; i < lines.size(); i++) { // Skip header row
                String[] line = lines.get(i);

                // Extract the relevant fields
                String storeName = line[1]; // Assuming storeName is the second column
                String phoneNumber = line[4]; // Assuming phoneNumber is the fifth column
                String storeAddr = line[2]; // Assuming storeAddr is the third column (road address)

                // Create Stores object
                csvStore store = csvStore.builder()
                        .storeName(storeName)
                        .phoneNumber(phoneNumber)
                        .address(storeAddr)
                        .build();

                // Check if the store already exists
                if (!csvDateRepository.existsByStoreNameAndPhoneNumberAndAddress(storeName, phoneNumber, storeAddr)) {
                    csvDateRepository.save(store);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
    
    @Transactional
	public List<csvStoreResponse.SearchMaps> searchForAllStore()
	{
		 List<csvStore> stores = csvDateRepository.findAll(); // Fetch all stores from the database
		 List<csvStoreResponse.SearchMaps> searchInfos = new ArrayList<>();
		 for (csvStore store : stores) {
		 	searchInfos.add(csvStoreResponse.SearchMaps.of(store));
		 }
		    
		 return searchInfos;
	}
	
}