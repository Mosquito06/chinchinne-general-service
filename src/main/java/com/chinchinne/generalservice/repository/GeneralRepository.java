package com.chinchinne.generalservice.repository;

import com.chinchinne.generalservice.domain.entity.General;
import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface GeneralRepository extends Repository<General, UserId>
{
    Optional<General> findByUserIdAndDelYn(UserId userId, Common delYn);
    Optional<List<General>> findAll(Specification<General> spec);
}
