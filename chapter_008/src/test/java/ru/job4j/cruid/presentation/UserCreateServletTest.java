package ru.job4j.cruid.presentation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.cruid.logic.Validate;
import ru.job4j.cruid.logic.ValidateService;
import ru.job4j.cruid.logic.ValidateStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class <Name class>.
 *
 * @author Alexey Rastorguev (rastorguev00@gmail.com)
 * @version 0.1
 * @since 09.11.18
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserCreateServletTest {

    @Test
    public void whenAddUser() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletResponse res = PowerMockito.mock(HttpServletResponse.class);
        HttpServletRequest req = PowerMockito.mock(HttpServletRequest.class);

        Mockito.when(req.getParameter("login")).thenReturn("Alexey");
        new UserCreateServlet().doPost(req, res);
        assertThat(validate.findAll().iterator().next().getName(), is("Alexey"));
    }
}