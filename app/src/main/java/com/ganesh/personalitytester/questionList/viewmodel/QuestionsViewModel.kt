package com.ganesh.personalitytester.questionList.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ganesh.personalitytester.base.BaseViewModel
import com.ganesh.personalitytester.base.Result
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecase
import com.ganesh.personalitytester.data.usecase.save_answer.AnswerUpdateUseCase
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import kotlinx.coroutines.flow.collect


class QuestionsViewModel(
    private val personalityQuestionUsecase: PersonalityQuestionUsecase,
    private val saveAnswerUseCase: AnswerUpdateUseCase
) :
    BaseViewModel() {
    val questions = MutableLiveData<List<QuestionUIData?>>()
    val answerSaving = MutableLiveData<Boolean>()
    val screenState = MutableLiveData<Result<Boolean>>()

    init {
        getAllQuestions()
    }

    fun saveAnswers() {
        launchCoroutine(
            {
                saveAnswerUseCase.saveAnswer(questions = questions.value).collect {
                    checkSavedResult(it)
                }
            }, screenState
        )
    }

    private fun checkSavedResult(status: Boolean) {
        if (status) {
            answerSaving.value = status
        }
    }

    private fun getAllQuestions() {
        launchCoroutine({
            personalityQuestionUsecase.getQuestions().collect {
                questions.value = it
            }
        }, screenState)
    }

}