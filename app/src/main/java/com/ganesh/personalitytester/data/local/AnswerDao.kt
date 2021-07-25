package com.ganesh.personalitytester.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface AnswerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswerTypeTable(favoriteEntity: AnswerTypeEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingleChoiceAnswer(favoriteEntity: SingleChoiceAnswerEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingleChoiceConditionalAnswer(favoriteEntity: SingleChoiceConditionalAnswerEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswerEntity(favoriteEntity: AnswerEntity): Long

}