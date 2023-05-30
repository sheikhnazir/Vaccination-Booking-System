package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDTO.CenterRequestDto;
import com.example.Dosify.dto.ResponseDTO.CenterResponseDto;
import com.example.Dosify.model.VaccinationCenter;
import com.example.Dosify.repository.CenterRepository;
import com.example.Dosify.service.VaccinationCenterService;
import com.example.Dosify.transformer.VaccinationCenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements VaccinationCenterService {
    @Autowired
    CenterRepository centerRepository;

    @Override
    public CenterResponseDto addCenter(CenterRequestDto centerRequestDto) {

        //Convert dto to entity using transformer (@builder annotation of lambok library)
        VaccinationCenter vaccinationCenter = VaccinationCenterTransformer.CenterRequestDtoToCenter(centerRequestDto);

        //Save to repository/database
        VaccinationCenter savedCenter = centerRepository.save(vaccinationCenter);

        // Convert entity to response dto and return it
        return VaccinationCenterTransformer.CenterToCenterResponseDto(savedCenter);

        }
}
