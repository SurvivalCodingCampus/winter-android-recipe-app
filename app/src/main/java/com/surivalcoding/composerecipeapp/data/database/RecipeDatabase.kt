package com.surivalcoding.composerecipeapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


/*
* recipe Room database
*
* entites: 어떤 Entity를 사용하는지 DB에 알려줌
* version: 현재 Database나 Entity가 변경될때마다 버전 1씩 올려줌
* exportSchema: 자동 마이그레이션시 사용
* */

@Database(entities = [RecipeEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class) // TypeConverter 적용
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}