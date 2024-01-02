package com.smilegate.blog.service.mapper;

import com.smilegate.blog.domain.BlockLink;
import com.smilegate.blog.domain.BlockMedia;
import com.smilegate.blog.domain.BlockProfile;
import com.smilegate.blog.domain.BlockSNSConnection;
import com.smilegate.blog.domain.BlockText;
import com.smilegate.blog.domain.vo.Image;
import com.smilegate.blog.domain.vo.Link;
import com.smilegate.blog.domain.vo.text.ContentBaseText;
import com.smilegate.blog.domain.vo.text.InstagramText;
import com.smilegate.blog.domain.vo.text.MainBaseText;
import com.smilegate.blog.domain.vo.text.SubBaseText;
import com.smilegate.blog.domain.vo.text.TelephoneBaseText;
import com.smilegate.blog.domain.vo.text.TitleBaseText;
import com.smilegate.blog.controller.dto.entity.BlockDTO;
import com.smilegate.blog.controller.dto.entity.BlockLinkDTO;
import com.smilegate.blog.controller.dto.entity.BlockMediaDTO;
import com.smilegate.blog.controller.dto.entity.BlockProfileDTO;
import com.smilegate.blog.controller.dto.entity.BlockSNSConnectionDTO;
import com.smilegate.blog.controller.dto.entity.BlockTextDTO;
import com.smilegate.blog.service.dto.UpdatePageRequest;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdatePageRequestMapper {
    public static UpdatePageRequest create(
            String id
            , String name
            , BlockProfileDTO profile
            , List<BlockDTO> blocks
    ) {
        return new UpdatePageRequest(
                id
                , new MainBaseText(name)
                , new BlockProfile(
                new MainBaseText(profile.getMain())
                , new SubBaseText(profile.getSub())
                , new Image(new Link(profile.getProfileImage()))
        )
                , blocks.stream().map(blockDTO -> {
                    if (blockDTO instanceof BlockProfileDTO object) {
                        return new BlockProfile(
                                new MainBaseText(object.getMain())
                                , new SubBaseText(object.getSub())
                                , new Image(new Link(object.getProfileImage()))
                        );
                    } else if (blockDTO instanceof BlockLinkDTO object) {
                        return new BlockLink(
                                new TitleBaseText(object.getTitle())
                                , new Link(object.getLink())
                                , new Image(new Link(object.getImage()))
                        );
                    } else if (blockDTO instanceof BlockMediaDTO object) {
                        return new BlockMedia(
                                new TitleBaseText(object.getTitle())
                                , new Link(object.getLink())
                        );
                    } else if (blockDTO instanceof BlockSNSConnectionDTO object) {
                        return new BlockSNSConnection(
                                new InstagramText(object.getInstagram())
                                , new TelephoneBaseText(object.getTelephone())
                        );
                    } else if (blockDTO instanceof BlockTextDTO object) {
                        return new BlockText(
                                new TitleBaseText(object.getTitle())
                                , new ContentBaseText(object.getContent())
                                , object.getTextAlignment()
                        );
                    }

                    throw new IllegalStateException("Unexpected value: " + blockDTO);
                }
        ).toList()
        );
    }
}
