package com.korit.senicare.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.senicare.dto.response.ResponseDto;
import com.korit.senicare.dto.response.nurse.GetSignInResponseDto;
import com.korit.senicare.entity.NurseEntity;
import com.korit.senicare.repository.NurseRepository;
import com.korit.senicare.service.NurseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NurseServiceImplement implements NurseService {

    private final NurseRepository nurseRepository;

    NurseEntity nurseEntity = null;

    @Override
    public ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId) {
        try {
            nurseEntity = nurseRepository.findByUserId(userId);
            if (nurseEntity == null)
                return ResponseDto.noExistUserId();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInResponseDto.success(nurseEntity);
    }

}
