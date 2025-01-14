# 🥘 RecipeApp

![readme_mockup](https://www.bing.com/images/blob?bcid=rxzIpuvaRPsHiQ)

## 프로젝트 소개

이 레시피 앱은 개인의 Kotlin과 안드로이드 학습 여정을 담은 실습 프로젝트입니다.
Figma 커뮤니티의 Recipe UI 디자인을 참고하여, Jetpack Compose로 안드로이드 앱을 직접 구현하며 배운 이론을 실무에 적용하는 것이 주요 목표입니다.
학습 과정에서 디자인 시스템 구축, 컴포넌트 설계, UI/UX 최적화 등을 직접 경험하고, 이를 통해 실질적인 모바일 개발 역량을 키워나가고자 합니다.

## 개발 환경

- 개발 언어: Kotlin
- 프레임워크: Android Jetpack Compose
- 개발 도구: Android Studio
- 디자인 참고: [Figma 커뮤니티 Recipe UI](https://www.figma.com/community/file/1117253657372214910/food-recipe-app)

## 프로젝트 구조
├── app
│   ├── manifests
│   ├── kotlin+java
│   │   ├── com.survivalcoding.composerecipeapp
│   │   │   ├── presentation
│   │   │   │   └── component
│   │   │   │       ├── BigButton.kt
│   │   │   │       ├── InputField.kt
│   │   │   │       ├── MediumButton.kt
│   │   │   │       ├── SmallButton.kt
│   │   │   │       └── Tabs.kt
│   │   │   └── ui
│   │   │       └── theme
│   │   │           ├── AppColors.kt
│   │   │           ├── AppTextStyles.kt
│   │   │           ├── Color.kt
│   │   │           ├── Theme.kt
│   │   │           └── Type.kt
│   │   └── com.survivalcoding.composerecipeapp.androidTest
│   │       └── presentation
│   │           └── component
│   │               ├── BigButtonTest.kt
│   │               ├── InputFieldTest.kt
│   │               ├── MediumButtonTest.kt
│   │               ├── SmallButtonTest.kt
│   │               └── TabsTest.kt
│   └── res

## 프로젝트 진행 상황

### 개발 기간
- 전체 개발 기간 : 2025-01-14 ~ 2025-02-19
- UI 구현 : 2025-01-14 ~
- 기능 구현 : 

### 일일 작업 일지
- [1일차](/docs/daily/2025-01-14.md) - 프로젝트 초기 디자인 시스템 및 컴포넌트 구현 시작

## 학습 로드맵

### Kotlin 및 안드로이드 학습 커리큘럼

#### Kotlin
- [V] Kotlin 오리엔테이션, 환경설정, Git 기초
- [V] Kotlin 문법 기초 (워밍업)
- [V] 인스턴스와 클래스
- [V] 클래스 심화
- [V] 캡슐화 / 컬렉션
- [V] 상속
- [V] 추상클래스와 인터페이스
- [V] 다형성
- [V] 인스턴스의 기본 조작
- [V] 제네릭, 열거형, 문자열 조작
- [V] 예외 처리, 파일 조작, 데이터 형식
- [V] 디버깅, 람다식과 함수
- [V] 비동기 프로그래밍

#### 설계 및 아키텍처
- [V] DataSource 개념
- [V] Model, Repository
- [V] Unit Test
- [V] Dto, Mapper
- [V] 네트워크 통신
- [V] Result 패턴
- [V] 설계 원칙

#### 모던 안드로이드
- [V] 앱 생태계 개론(Android, iOS, 멀티플랫폼)
- [V] Composable 작성 규칙
- [x] 상태가 있는 Composable 작성 규칙
- [x] 상태관리, Activity 생명주기
- [x] 네비게이션
- [x] MVVM 패턴
- [x] 단일 상태 객체 도입
- [x] 클린 아키텍처
- [x] 의존성 주입
- [x] 1회성 UI Event 처리
- [x] UI/통합 Test
- [x] 고급 상태관리 기법

#### 고급 안드로이드 주제
- [x] Broadcast Receiver
- [x] Content Provider
- [x] Service
- [x] 데이터 저장
- [x] 생성형 AI 활용 앱 개발

#### 안드로이드 심화
- [x] Intent, Context, View, ViewGroup
- [x] Fragment
- [x] 리스트(RecyclerView)
- [x] 리소스
- [x] Menu
- [x] ViewBinding