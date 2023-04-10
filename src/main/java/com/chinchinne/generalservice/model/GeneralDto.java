package com.chinchinne.generalservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class GeneralDto
{
    String userId;
    BigInteger budget;
}
