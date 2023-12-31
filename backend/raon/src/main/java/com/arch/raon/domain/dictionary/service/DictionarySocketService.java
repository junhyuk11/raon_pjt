package com.arch.raon.domain.dictionary.service;

import java.util.List;

import com.arch.raon.domain.dictionary.dto.request.SocketQuizReqDTO;
import com.arch.raon.domain.dictionary.dto.response.DictionaryQuizResDTO;
import com.arch.raon.domain.dictionary.dto.response.socket.SocketQuizDTO;
import com.arch.raon.domain.dictionary.dto.response.socket.SocketStageResultResDTO;
import com.arch.raon.domain.dictionary.vo.User;
import com.arch.raon.global.util.enums.RoomResult;

public interface DictionarySocketService {
	RoomResult connectRoom(String nickname, String roomId);

	RoomResult leaveRoom(String nickname, String roomId);

	RoomResult startGame(String roomId, String nickname);

	DictionaryQuizResDTO getQuizes();

	void addQuizToRoom(DictionaryQuizResDTO quizes, String roomId);

	SocketQuizDTO getNextQuizFrom(String roomId);

	RoomResult addAnswerToRoom(SocketQuizReqDTO reqDTO);

	SocketStageResultResDTO getStageResultOf(String roomId);

    void saveScore(String roomId);

	List<User> getUsersOf(String roomId);

	String getOwnerOf(String roomId);
}
