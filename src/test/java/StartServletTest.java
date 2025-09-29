import com.javarush.bogomolov.quest.constants.AppConstants;
import com.javarush.bogomolov.quest.servlets.StartServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartServletTest {

    private StartServlet startServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    public void init() {

       startServlet = new StartServlet();
       request = mock(HttpServletRequest.class);
       response = mock(HttpServletResponse.class);
       session = mock(HttpSession.class);

       when(request.getSession()).thenReturn(session);
    }

    @Test
    public void whenCallDoGetThenSessionSetAttributeAndRedirect() throws ServletException, IOException {

        when(session.getAttribute(AppConstants.SessionParameters.START)).thenReturn(null);

        startServlet.doGet(request, response);

        verify(session).setAttribute(AppConstants.SessionParameters.START, true);
        verify(session).setAttribute(AppConstants.SessionParameters.WEAPON, false);
        verify(session).setAttribute(AppConstants.SessionParameters.DEAD, false);
        verify(session).setAttribute(AppConstants.SessionParameters.WIN, false);
        verify(session).setAttribute(AppConstants.SessionParameters.QUESTION, null);
        verify(session).setAttribute(AppConstants.SessionParameters.NUMBER_GAME_COMPLETED, 0);

        verify(response).sendRedirect("index.jsp");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ANSWER_1_3", "ANSWER_2_3"})
    public void whenCallDoPostThenSessionSetAttributeQuestion(String testAnswer) throws ServletException, IOException {

        when(request.getParameter("answer")).thenReturn(testAnswer);

        startServlet.doPost(request, response);

        verify(session).setAttribute(AppConstants.SessionParameters.QUESTION, AppConstants.Question.QUESTION_3);
        verify(response).sendRedirect("index.jsp");
    }

    @Test
    public void whenCallSetAttributeMethodWithNullAnswerAttributeThenError() {
        when(request.getParameter("answer")).thenReturn(null);

        assertThrows(Error.class, () -> startServlet.doPost(request, response));
    }

}
