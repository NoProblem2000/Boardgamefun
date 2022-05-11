package com.petproject.boardgamefun.service;

import com.petproject.boardgamefun.dto.DiaryCommentDTO;
import com.petproject.boardgamefun.model.DiaryComment;
import com.petproject.boardgamefun.service.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryCommentService {

    final UserMapper userMapper;

    public DiaryCommentService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public DiaryCommentDTO entityToDiaryCommentDTO(DiaryComment diaryComment) {
        return new DiaryCommentDTO(diaryComment.getId(), diaryComment.getComment(), diaryComment.getCommentTime(), userMapper.userToUserDTO(diaryComment.getUser()));
    }

    public List<DiaryCommentDTO> entitiesToCommentDTO(List<DiaryComment> diaryComments){
        ArrayList<DiaryCommentDTO> diaryCommentsDTO = new ArrayList<>();
        for (var diaryComment :
                diaryComments) {
            diaryCommentsDTO.add(new DiaryCommentDTO(diaryComment.getId(), diaryComment.getComment(), diaryComment.getCommentTime(), userMapper.userToUserDTO(diaryComment.getUser())));
        }
        return diaryCommentsDTO;
    }
}
