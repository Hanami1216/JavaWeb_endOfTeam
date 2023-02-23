package yokiware.controller;

import yokiware.entity.User;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;
import yokiware.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/5  14:12
 */
@WebServlet("/login/*")
public class LoginController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        User user = userService.getById(Integer.parseInt(req.getParameter("id")));
        if (user != null) {
            if (user.getPassword().equals(req.getParameter("password"))) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_OK, "登录成功", true));
            } else JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_ERR, "登录失败", false));
        }
        JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_ERR, "登录失败", false));

    }


}
