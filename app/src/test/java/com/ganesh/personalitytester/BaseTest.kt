package com.ganesh.personalitytester

import com.ganesh.personalitytester.helpers.MockServerBaseTestInterface
import com.ganesh.personalitytester.helpers.MockServerBaseTestInterfaceImpl
import org.junit.After
import org.junit.Before


open class UseCaseBaseTest(
    private val remote: MockServerBaseTestInterface = MockServerBaseTestInterfaceImpl()
) : MockServerBaseTestInterface by remote {

    @Before
    open fun setup() {
        remote.setupMockServer()
    }

    @After
    open fun tearDown() {
        remote.closeMockServer()
    }

}
