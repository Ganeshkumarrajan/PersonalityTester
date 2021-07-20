package com.ganesh.personalitytester.data.usecase.personality_question

import com.ganesh.personalitytester.BaseTest
import com.ganesh.personalitytester.data.PersonalityQuestionUsecase
import com.ganesh.personalitytester.questionList.QuestionType
import com.ganesh.personalitytester.questionList.SingleChoiceConditionalQuestionUiData
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PersonalityQuestionUsecaseImplTest : BaseTest() {
    private lateinit var usecase: PersonalityQuestionUsecase

    @Before
    override fun setup() {
        super.setup()
        usecase = PersonalityQuestionUsecaseImpl(personalityQuestionsApiService)
    }

    @Test
    fun `check all the question types are formed from the endpoint result`() = runBlocking {
        //when
        val results = usecase.getQuestions()
        //result
        results.collect {
            Truth.assertThat(it.size).isEqualTo(25)
            Truth.assertThat(it[0]?.questionType).isEqualTo(QuestionType.SINGLE_CHOICE)
            Truth.assertThat(it[2]?.questionType)
                .isEqualTo(QuestionType.SINGLE_CHOICE_CONDITIONAL)
            Truth.assertThat((it[2] as SingleChoiceConditionalQuestionUiData).subQuestionData.questionType)
                .isEqualTo(QuestionType.NUMBER_RANGE)
        }
    }
}