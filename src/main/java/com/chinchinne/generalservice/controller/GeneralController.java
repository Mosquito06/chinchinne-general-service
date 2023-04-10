package com.chinchinne.generalservice.controller;

import com.chinchinne.generalservice.domain.entity.General;
import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import com.chinchinne.generalservice.exception.CustomException;
import com.chinchinne.generalservice.model.ErrorCode;
import com.chinchinne.generalservice.model.GeneralDto;
import com.chinchinne.generalservice.repository.GeneralRepository;
import com.chinchinne.generalservice.spec.GeneralSpecs;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class GeneralController
{
    ModelMapper modelMapper;

    GeneralRepository generalRepository;

    public GeneralController(ModelMapper modelMapper, GeneralRepository generalRepository)
    {
        this.modelMapper = modelMapper;
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
}
