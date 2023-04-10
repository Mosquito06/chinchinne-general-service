package com.chinchinne.generalservice.spec;

import com.chinchinne.generalservice.domain.entity.General;
import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import org.springframework.data.jpa.domain.Specification;

public class GeneralSpecs
{
    public static Specification<General> UserId(UserId userId)
    {
        return (root, query, builder) -> builder.equal(root.get("userId").get("id"), userId.getId());
    }

    public static Specification<General> DelYn(Common delYn)
    {
        return (root, query, builder) -> builder.equal(root.get("delYn"), delYn);
    }
}
