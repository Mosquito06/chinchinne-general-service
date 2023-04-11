package com.chinchinne.generalservice.service;

import com.chinchinne.generalservice.domain.entity.General;
import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import com.chinchinne.generalservice.exception.CustomException;
import com.chinchinne.generalservice.model.ErrorCode;
import com.chinchinne.generalservice.model.GeneralDto;
import com.chinchinne.generalservice.repository.GeneralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public GeneralDto changeGeneral(GeneralDto generalDto)
    {
        Optional<General> opGeneral = generalRepository.findByUserIdAndDelYn(new UserId(generalDto.getUserId()), Common.NO);

        if( opGeneral.isEmpty() )
        {
            throw new CustomException(ErrorCode.NOT_FOUND_RECORD);
        }

        General general = opGeneral.get();

        general.changeGeneral
        (
            new UserId(generalDto.getUserId())
            ,generalDto.getBudget()
        );

        return modelMapper.map(general, GeneralDto.class);
    }
}
