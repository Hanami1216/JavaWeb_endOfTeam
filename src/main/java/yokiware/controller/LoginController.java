package yokiware.controller;

import yokiware.entity.User;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;
import yokiware.util.JSONUtil;
import yokiware.vo.Login;

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
                if (user.getPower() == 0) {
                    JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_OK, "普通用户登录成功", new Login(true, 0)));
                } else if (user.getPower() == 1) {
                    JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_OK, "管理员登录成功", new Login(true, 1)));
                }

            } else JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_ERR, "登录失败", new Login(false, 2)));
        }
        JSONUtil.responseOutWithJson(resp, new Result(Code.LOIN_ERR, "登录失败", false));

    }


}
