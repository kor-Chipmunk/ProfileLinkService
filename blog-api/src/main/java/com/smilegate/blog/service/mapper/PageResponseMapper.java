package com.smilegate.blog.service.mapper;

import com.smilegate.blog.domain.Block;
import com.smilegate.blog.domain.BlockLink;
import com.smilegate.blog.domain.BlockMedia;
import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.domain.BlockSNSConnection;
import com.smilegate.blog.domain.BlockText;
import com.smilegate.blog.domain.Page;
import com.smilegate.blog.domain.vo.Image;
import com.smilegate.blog.domain.vo.Link;
import com.smilegate.blog.domain.vo.text.ContentBaseText;
import com.smilegate.blog.domain.vo.text.InstagramText;
import com.smilegate.blog.domain.vo.text.MainBaseText;
import com.smilegate.blog.domain.vo.text.SubBaseText;
import com.smilegate.blog.domain.vo.text.TelephoneBaseText;
import com.smilegate.blog.domain.vo.text.TitleBaseText;
import com.smilegate.blog.entity.mongo.BlockEntity;
import com.smilegate.blog.entity.mongo.BlockLinkEntity;
import com.smilegate.blog.entity.mongo.BlockMediaEntity;
import com.smilegate.blog.entity.mongo.BlockProfileEntity;
import com.smilegate.blog.entity.mongo.BlockSNSConnectionEntity;
import com.smilegate.blog.entity.mongo.BlockTextEntity;
import com.smilegate.blog.entity.mongo.PageEntity;
import com.smilegate.blog.service.dto.PageResponse;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageResponseMapper {
    public static PageResponse create(PageEntity pageEntity) {
        Page page = new Page(
                new MainBaseText(pageEntity.getName())
                , getBlockProfile(pageEntity.getBlockProfile())
                , getBlocks(pageEntity.getBlocks())
        );

        return new PageResponse(
                pageEntity.getId()
                , page
        );
    }

    private static BlockProfile getBlockProfile(BlockProfileEntity profileEntity) {
        if (profileEntity == null) {
            return null;
        }

        return new BlockProfile(
                new MainBaseText(profileEntity.getMain())
                , new SubBaseText(profileEntity.getSub())
                , new Image(new Link(profileEntity.getImage()))
        );
    }

    private static List<Block> getBlocks(List<BlockEntity> blockEntities) {
        if (blockEntities == null) {
            return List.of();
        }

        if (blockEntities.isEmpty()) {
            return List.of();
        }

        return blockEntities.stream().map(blockEntity ->
                {
                    if (blockEntity instanceof BlockProfileEntity object) {
                        return new BlockProfile(
                                new MainBaseText(object.getMain())
                                , new SubBaseText(object.getSub())
                                , new Image(new Link(object.getImage()))
                        );
                    } else if (blockEntity instanceof BlockLinkEntity object) {
                        return new BlockLink(
                                new TitleBaseText(object.getTitle())
                                , new Link(object.getLink())
                                , new Image(new Link(object.getImage()))
                        );
                    } else if (blockEntity instanceof BlockMediaEntity object) {
                        return new BlockMedia(
                                new TitleBaseText(object.getTitle())
                                , new Link(object.getLink())
                        );
                    } else if (blockEntity instanceof BlockSNSConnectionEntity object) {
                        return new BlockSNSConnection(
                                new InstagramText(object.getInstagram())
                                , new TelephoneBaseText(object.getTelephone())
                        );
                    } else if (blockEntity instanceof BlockTextEntity object) {
                        return new BlockText(
                                new TitleBaseText(object.getTitle())
                                , new ContentBaseText(object.getContent())
                                , object.getTextAlignment()
                        );
                    }

                    throw new IllegalStateException("Unexpected value: " + blockEntity);
                }
        ).toList();
    }
}
