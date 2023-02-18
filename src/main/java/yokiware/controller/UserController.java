package yokiware.controller;

import org.apache.log4j.Logger;
import yokiware.entity.User;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;
import yokiware.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/5  14:12
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private final UserService userService = new UserServiceImpl();
    private List<User> userList;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = userService.getById(Integer.parseInt(req.getParameter("id")));
        if (user != null) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功", user));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败", null));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
