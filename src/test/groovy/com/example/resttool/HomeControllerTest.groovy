/**
 * Credit: https://github.com/eugenp/tutorials/blob/master/spring-boot-testing/src/test/groovy/com/baeldung/boot/WebControllerTest.groovy
 */

package com.example.resttool

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Title

@Title("HomeController Specification")
@Narrative("The Specification of the behaviour of the HomeController. It will reply with 'Welcome !'.")
@AutoConfigureMockMvc(secure=false)
@WebMvcTest()
class HomeControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    def "when get is performed then the response has status 200 and content is 'Welcome !'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response.contentAsString == "Welcome !"
    }
}