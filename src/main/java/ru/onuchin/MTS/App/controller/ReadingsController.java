package ru.onuchin.MTS.App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.onuchin.MTS.App.dto.ReadingDTO;
import ru.onuchin.MTS.App.service.ReadingsService;

@RestController
@RequestMapping("/api/readings")
public class ReadingsController {

    private final ReadingsService readingsService;

    @Autowired
    public ReadingsController(ReadingsService readingsService) {
        this.readingsService = readingsService;
    }

    @GetMapping("/latest")
    public ResponseEntity<ReadingDTO> getReading() {
        ReadingDTO readingsDTO = readingsService.getReading();
        return new ResponseEntity<>(readingsDTO, HttpStatus.OK);
    }
}
