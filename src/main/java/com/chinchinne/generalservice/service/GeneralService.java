package com.chinchinne.generalservice.service;

import com.chinchinne.generalservice.repository.GeneralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class GeneralService
{
    ModelMapper modelMapper;

    GeneralRepository generalRepository;

    public GeneralService(ModelMapper modelMapper, GeneralRepository generalRepository)
    {
        this.modelMapper = modelMapper;
        this.generalRepository = generalRepository;
    }
}
