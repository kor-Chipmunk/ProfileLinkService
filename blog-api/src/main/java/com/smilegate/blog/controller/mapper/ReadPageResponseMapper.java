package com.smilegate.blog.controller.mapper;

import com.smilegate.blog.controller.dto.ReadPageResponseDTO;
import com.smilegate.blog.controller.dto.entity.BlockLinkDTO;
import com.smilegate.blog.controller.dto.entity.BlockMediaDTO;
import com.smilegate.blog.controller.dto.entity.BlockProfileDTO;
import com.smilegate.blog.controller.dto.entity.BlockSNSConnectionDTO;
import com.smilegate.blog.controller.dto.entity.BlockTextDTO;
import com.smilegate.blog.domain.BlockLink;
import com.smilegate.blog.domain.BlockMedia;
import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.domain.BlockSNSConnection;
import com.smilegate.blog.domain.BlockText;
import com.smilegate.blog.service.dto.PageResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReadPageResponseMapper {
    public static ReadPageResponseDTO create(PageResponse pageResponse) {
        return new ReadPageResponseDTO(
                pageResponse.pageId()
                , pageResponse.page().getName().getText()
                , new BlockProfileDTO(
                        pageResponse.page().getProfile().getMain().getText()
                        , pageResponse.page().getProfile().getSub().getText()
                        , pageResponse.page().getProfile().getProfileImage().link().url()
                )
                , pageResponse.page().getBlocks().stream().map(block -> {
                    if (block instanceof BlockLink object) {
                        return new BlockLinkDTO(
                                object.getTitle().getText()
                                , object.getLink().url()
                                , object.getImage().link().url()
                        );
                    } else if (block instanceof BlockMedia object) {
                        return new BlockMediaDTO(
                                object.getTitle().getText()
                                , object.getLink().url()
                        );
                    } else if (block instanceof BlockProfile object) {
                        return new BlockProfileDTO(
                                object.getMain().getText()
                                , object.getSub().getText()
                                , object.getProfileImage().link().url()
                        );
                    } else if (block instanceof BlockSNSConnection object) {
                        return new BlockSNSConnectionDTO(
                                object.getInstagram().getText()
                                , object.getTelephone().getText()
                        );
                    } else if (block instanceof BlockText object) {
                        return new BlockTextDTO(
                                object.getTitle().getText()
                                , object.getContent().getText()
                                , object.getTextAlignment()
                        );
                    }

                    throw new IllegalStateException("Unexpected value: " + block);
                }).toList()
        );
    }
}
