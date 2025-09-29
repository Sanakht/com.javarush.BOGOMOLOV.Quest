import com.javarush.bogomolov.quest.servlets.RestartServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestartServletTest {
    private static final String path = "index.jsp";

    @Test
    public void whenCallDoPostThenRestartServletReturnIndexPage() throws ServletException, IOException {

        RestartServlet servlet = new RestartServlet();

        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        final HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        servlet.doPost(request, response);

        verify(request,never()).getParameter("name");
        verify(session).invalidate();
        verify(request, times(1)).getSession();
        verify(response).sendRedirect(path);
        verify(response,times(1)).sendRedirect(path);

    }

}
