package com.chinchinne.generalservice.domain.entity;

import com.chinchinne.generalservice.domain.model.Common;
import com.chinchinne.generalservice.domain.value.UserId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

import static java.sql.Timestamp.valueOf;

@Entity
@Table(name = "GENERAL")
@NoArgsConstructor
@Getter
@Access( AccessType.FIELD )
public class General
{
    @Id
    //@Column(name = "USER_ID")
    private UserId userId;

    @Column( name = "BUDGET" )
    private BigInteger budget;

    @Column( name = "REG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column( name = "MOD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;

    @Embedded
    @AttributeOverrides
    (
        @AttributeOverride( name = "id", column = @Column( name = "MOD_ID"))
    )
    private UserId modId;

    @Column( name = "DEL_YN")
    private Common delYn;

    public void changeGeneral( UserId userId, BigInteger budget )
    {
        this.userId = userId;
        this.budget = budget;
        this.modDate = valueOf(LocalDateTime.now());
        this.modId = userId;
    }
}
