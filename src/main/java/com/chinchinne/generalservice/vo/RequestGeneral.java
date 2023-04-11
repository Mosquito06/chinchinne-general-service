package com.chinchinne.generalservice.vo;


import com.chinchinne.generalservice.domain.model.Common;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class RequestGeneral
{
    private String userId;

    @Min(0)
    private BigInteger budget;
}
