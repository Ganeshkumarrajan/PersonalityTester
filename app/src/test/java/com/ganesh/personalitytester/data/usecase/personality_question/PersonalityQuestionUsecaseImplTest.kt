package com.ganesh.personalitytester.data.usecase.personality_question


import com.ganesh.personalitytester.UseCaseBaseTest
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecase
import com.ganesh.personalitytester.data.usecase.question_list.PersonalityQuestionUsecaseImpl
import com.ganesh.personalitytester.questionList.model.QuestionType
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class PersonalityQuestionUsecaseImplTest : UseCaseBaseTest() {
    private lateinit var usecase: PersonalityQuestionUsecase

    @Before
    override fun setup() {
        super.setup()
        usecase = PersonalityQuestionUsecaseImpl(personalityQuestionsApiService)
    }

    @Test
    fun getQuestions_success_case() = runBlocking {
        //when
        val results = usecase.getQuestions()

        //result
        results.collect {
            Truth.assertThat(it.size).isEqualTo(25)
            Truth.assertThat(it[0]?.questionType).isEqualTo(QuestionType.SINGLE_CHOICE)
            Truth.assertThat(it[0]?.categoryName).isEqualTo("PASSION")
            Truth.assertThat(it[0]?.canShowCategoryName).isEqualTo(true)
            Truth.assertThat(it[1]?.canShowCategoryName).isEqualTo(false)
        }
    }

}