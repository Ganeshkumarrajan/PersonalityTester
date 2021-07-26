package com.ganesh.personalitytester.questionList.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ganesh.personalitytester.base.Result
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecase
import com.ganesh.personalitytester.data.usecase.save_answer.AnswerUpdateUseCase
import com.ganesh.personalitytester.helpers.MainCoroutineScopeRule
import com.ganesh.personalitytester.helpers.observeOnce
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.ganesh.personalitytester.questionList.model.QuestionUIData
import com.ganesh.personalitytester.questionList.model.SingleChoiceQuestionUiData
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@Suppress("DEPRECATION")
class QuestionsViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    private lateinit var personalityQuestionUsecase: PersonalityQuestionUsecase
    private lateinit var saveAnswerUseCase: AnswerUpdateUseCase
    private lateinit var viewModel: QuestionsViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        personalityQuestionUsecase = mock(PersonalityQuestionUsecase::class.java)
        saveAnswerUseCase = mock(AnswerUpdateUseCase::class.java)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getAllQuestions_success() {
        coroutineScope.runBlockingTest {
            //given
            val result = flow {
                emit(getQuestions())
            }
            `when`(personalityQuestionUsecase.getQuestions()).thenReturn(result)

            //when
            createViewMode()

            //result
            viewModel.screenState.observeOnce {
                Truth.assertThat(it is Result.Success).isTrue()
            }
            viewModel.questions.observeOnce {
                Truth.assertThat(it.size).isEqualTo(1)
            }

        }
    }


    private fun createViewMode() {
        viewModel = QuestionsViewModel(personalityQuestionUsecase, saveAnswerUseCase)
    }


    private fun getQuestions(): List<QuestionUIData> =
        listOf<QuestionUIData>(
            SingleChoiceQuestionUiData(
                name = "question name",
                QuestionType.SINGLE_CHOICE, true, "hard", listOf("yes", "yes")
            )
        )


}