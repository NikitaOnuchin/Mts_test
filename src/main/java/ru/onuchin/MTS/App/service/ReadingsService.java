package ru.onuchin.MTS.App.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onuchin.MTS.App.dto.ReadingDTO;
import ru.onuchin.MTS.App.model.Reading;
import ru.onuchin.MTS.App.repository.ReadingRepository;

@Service
@Transactional(readOnly = true)
public class ReadingsService {

    private final ReadingRepository readingRepository;
    @Autowired
    public ReadingsService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    @Transactional
    public void saveReadings(int value) {
            readingRepository.postReadings(value);
    }

    public ReadingDTO getReading() {
        Reading reading = readingRepository.getReading();
        return convertReadingToReadinDTO(reading);
    }

    private ReadingDTO convertReadingToReadinDTO(Reading reading) {
        ReadingDTO readingDTO = new ReadingDTO();
        readingDTO.setId(reading.getId());
        readingDTO.setTs(reading.getTs());
        readingDTO.setValue(reading.getValue());
        return readingDTO;
    }
}
