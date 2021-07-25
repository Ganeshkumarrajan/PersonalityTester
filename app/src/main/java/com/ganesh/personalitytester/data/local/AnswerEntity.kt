package com.ganesh.personalitytester.data.local

import androidx.room.*

@Entity(tableName = "SingleChoiceAnswerEntity")
class SingleChoiceAnswerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "question_name") val questionName: String,
    @ColumnInfo(name = "answer") val answer: String,
)

@Entity(tableName = "SingleChoiceConditionalAnswerEntity")
class SingleChoiceConditionalAnswerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "question_name") val questionName: String,
    @ColumnInfo(name = "answer") val answer: String,
    @ColumnInfo(name = "condition") val condition: String,
    @ColumnInfo(name = "range") val range: String,
)

@Entity(tableName = "AnswerTypeEntity")
class AnswerTypeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "type") val questionName: String,
)

@Entity(tableName = "AnswerEntity")
class AnswerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "question_name") val questionName: String,
    @ColumnInfo(name = "answer_type") val answerType: String,
    @ColumnInfo(name = "answerID") val answerID: Int
)

