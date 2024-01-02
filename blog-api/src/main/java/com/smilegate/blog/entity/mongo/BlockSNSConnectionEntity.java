package com.smilegate.blog.entity.mongo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("sns")
@Getter
@NoArgsConstructor
public final class BlockSNSConnectionEntity extends BlockEntity {
    private String instagram;
    private String telephone;

    public BlockSNSConnectionEntity(
            String instagram
            , String telephone
    ) {
        this.instagram = instagram;
        this.telephone = telephone;
    }
}
