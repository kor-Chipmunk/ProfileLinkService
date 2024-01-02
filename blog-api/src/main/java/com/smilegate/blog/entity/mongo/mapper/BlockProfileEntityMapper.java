package com.smilegate.blog.entity.mongo.mapper;

import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.entity.mongo.BlockProfileEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockProfileEntityMapper {
    public static BlockProfileEntity create(BlockProfile profile) {
        if (null == profile) {
            return null;
        }

        return new BlockProfileEntity(
                profile.getMain().getText()
                , profile.getSub().getText()
                , profile.getProfileImage().link().url()
        );
    }
}
