package org.example.day19.repository

import org.example.day19.data_source.UserDataSource
import org.example.day19.model.LoginType
import org.example.day19.model.LoginUser
import org.example.day19.model.SignupUser
import org.example.day19.model.User

/**
 * AuthRepository 는 로그인, 회원가입, 로그아웃, 회원탈퇴 등
 * 인증 관련 기능을 제공하는 repository
 */
interface AuthRepository {

    /**
     * 로그인
     * 로그인 타입에 따라서 로그인을 진행한다.
     */
    suspend fun login(loginUser: LoginUser, loginType: LoginType): User

    /**
     * 회원가입
     * 회원가입 타입에 따라서 회원가입을 진행한다.
     */
    suspend fun signup(signupUser: SignupUser, loginType: LoginType): User

    /**
     * 로컬 DB에 저장된 User를 반환
     */
    suspend fun getUser(): User

    /**
     * SecurePref 에 저장된 토큰을 날림
     * 로그아웃
     */
    suspend fun logout()

    /**
     * 회원탈퇴
     * 로그인 타입에 따라 회원탈퇴를 진행한다.
     * 서버와 통신하여 유저정보 삭제 후 logout()을 호출한다.
     */
    suspend fun withDraw()
}