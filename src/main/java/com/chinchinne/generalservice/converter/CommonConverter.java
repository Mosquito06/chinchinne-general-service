package com.chinchinne.generalservice.converter;

import com.chinchinne.generalservice.domain.model.Common;

import javax.persistence.Converter;

@Converter( autoApply = true )
public class CommonConverter extends CodeValueConverter<Common>
{
    public CommonConverter()
    {
        super(Common.class);
    }
}
