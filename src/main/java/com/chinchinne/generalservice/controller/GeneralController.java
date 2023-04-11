package com.chinchinne.generalservice.controller;

import com.chinchinne.generalservice.domain.entity.General;
import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import com.chinchinne.generalservice.model.GeneralDto;
import com.chinchinne.generalservice.repository.GeneralRepository;
import com.chinchinne.generalservice.service.GeneralService;
import com.chinchinne.generalservice.vo.RequestGeneral;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GeneralController
{
    ModelMapper modelMapper;

    GeneralService generalService;

    GeneralRepository generalRepository;

    public GeneralController(ModelMapper modelMapper, GeneralService generalService, GeneralRepository generalRepository)
    {
        this.modelMapper = modelMapper;
        this.generalService = generalService;
        this.generalRepository = generalRepository;
    }

    @GetMapping("/{userId}/general")
    public ResponseEntity<GeneralDto> getGeneral(@PathVariable String userId)
    {
        General general = generalRepository.findByUserIdAndDelYn(new UserId(userId), Common.NO)
                                            .orElseGet(General::new);

        GeneralDto res = modelMapper.map(general, GeneralDto.class);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{userId}/general")
    public ResponseEntity<GeneralDto> updateGeneral(@PathVariable String userId, @RequestBody @Valid RequestGeneral requestGeneral)
    {
        requestGeneral.setUserId(userId);

        GeneralDto generalDto = modelMapper.map(requestGeneral, GeneralDto.class);

        GeneralDto res = generalService.changeGeneral(generalDto);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
