package com.ganesh.personalitytester.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [SingleChoiceAnswerEntity::class,
        SingleChoiceConditionalAnswerEntity::class,
        AnswerTypeEntity::class,
        AnswerEntity::class
    ], version = 1, exportSchema = false
)
abstract class AnswerDataBase : RoomDatabase() {

    companion object {
        fun get(context: Context): AnswerDataBase {
            return Room.databaseBuilder(context, AnswerDataBase::class.java, "AnswerDataBase")
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun answerDAO(): AnswerDao
}