package com.ganesh.personalitytester.questionList

import androidx.lifecycle.MutableLiveData
import com.ganesh.personalitytester.base.BaseViewModel
import com.ganesh.personalitytester.base.Result
import com.ganesh.personalitytester.data.usecase.personality_question.PersonalityQuestionUsecase
import kotlinx.coroutines.flow.collect


class QuestionsViewModel(val personalityQuestionUsecase: PersonalityQuestionUsecase) :
    BaseViewModel() {

    val questions = MutableLiveData<Result<List<QuestionUIData?>>>()

    fun getAllQuestions() {
        launchCoroutine({
            personalityQuestionUsecase.getQuestions().collect {
                questions.value = Result.Success(it)
            }
        }, questions)
    }





}