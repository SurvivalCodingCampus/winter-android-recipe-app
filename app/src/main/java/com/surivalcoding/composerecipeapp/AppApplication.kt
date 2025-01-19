package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl

// AndroidManifest.xml에서 애플리케이션 이름으로 설정되어야 작동한다
// 싱글턴 객체
// 객체 순서에 영향이 없도록 lazy로 생성
class AppApplication: Application() {
    val recipeRepository by lazy { RecipeRepositoryImpl() }
    val recipeDataSource by lazy { }
}
