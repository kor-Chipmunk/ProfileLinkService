package com.smilegate.blog.controller.dto.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, property = "type")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = BlockLinkDTO.class, name = "link")
                , @JsonSubTypes.Type(value = BlockMediaDTO.class, name = "media")
                , @JsonSubTypes.Type(value = BlockProfileDTO.class, name = "profile")
                , @JsonSubTypes.Type(value = BlockSNSConnectionDTO.class, name = "sns")
                , @JsonSubTypes.Type(value = BlockTextDTO.class, name = "text")
        }
)
public abstract class BlockDTO {

}
