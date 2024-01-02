package com.smilegate.blog.entity.mongo.mapper;

import com.smilegate.blog.domain.Block;
import com.smilegate.blog.domain.BlockLink;
import com.smilegate.blog.domain.BlockMedia;
import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.domain.BlockSNSConnection;
import com.smilegate.blog.domain.BlockText;
import com.smilegate.blog.entity.mongo.BlockEntity;
import com.smilegate.blog.entity.mongo.BlockLinkEntity;
import com.smilegate.blog.entity.mongo.BlockMediaEntity;
import com.smilegate.blog.entity.mongo.BlockProfileEntity;
import com.smilegate.blog.entity.mongo.BlockSNSConnectionEntity;
import com.smilegate.blog.entity.mongo.BlockTextEntity;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BlockEntityMapper {
    public static List<BlockEntity> create(List<Block> blocks) {
        if (null == blocks) {
            return null;
        }

        return blocks.stream().map(block -> {
                    if (block instanceof BlockProfile object) {
                        return new BlockProfileEntity(
                                object.getMain().getText()
                                , object.getSub().getText()
                                , object.getProfileImage().link().url()
                        );
                    }
                    else if (block instanceof BlockLink object) {
                        return new BlockLinkEntity(
                                object.getTitle().getText()
                                , object.getLink().url()
                                , object.getImage().link().url()
                        );
                    }
                    else if (block instanceof BlockMedia object) {
                        return new BlockMediaEntity(
                                object.getTitle().getText()
                                , object.getLink().url()
                        );
                    }
                    else if (block instanceof BlockSNSConnection object) {
                        return new BlockSNSConnectionEntity(
                                object.getInstagram().getText()
                                , object.getTelephone().getText()
                        );
                    }
                    else if (block instanceof BlockText object) {
                        return new BlockTextEntity(
                                object.getTitle().getText()
                                , object.getContent().getText()
                                , object.getTextAlignment()
                        );
                    }

                    throw new IllegalStateException("Unexpected value: " + block);
                }
        ).toList();
    }
}