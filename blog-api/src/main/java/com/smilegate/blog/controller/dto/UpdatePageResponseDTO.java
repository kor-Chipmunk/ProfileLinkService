package com.smilegate.blog.controller.dto;

import com.smilegate.blog.controller.dto.entity.BlockDTO;
import com.smilegate.blog.controller.dto.entity.BlockProfileDTO;
import java.util.List;

public record UpdatePageResponseDTO(
        String id
        , String name
        , BlockProfileDTO profile
        , List<BlockDTO> blocks
) {

}