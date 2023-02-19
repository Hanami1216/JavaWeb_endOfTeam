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
import java.util.Arrays;
import java.util.List;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/5  14:12
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private final UserService userService = new UserServiceImpl();
    private List<User> userList;
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String requestURI = req.getRequestURI();
        String[] uriParts = requestURI.split("/");
        System.out.println(Arrays.toString(uriParts));

        // 获取所有用户信息
        if (uriParts.length == 3 || (uriParts.length == 4 && uriParts[3].isEmpty())) {
            userList = userService.getAll();
//            String usersJson = new Gson().toJson(users); // 将 Java 对象转换成 JSON 格式的字符串
//            response.setContentType("application/json"); // 将响应的内容类型设置为 JSON
//            response.getWriter().write(usersJson);
            if (userList != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回所有用户信息", userList));
            } else
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
        }
        // 获取单个用户信息
        else if (uriParts.length == 4) {

            int userId = Integer.parseInt(uriParts[3]);

            user = userService.getById(userId);
            if (user != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回单个用户信息", user));
            } else
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
        }
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
        if (userService.delById(Integer.parseInt(req.getParameter("id")))) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_OK, "DELETE成功", null));
        } else JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_ERR, "DELETE失败", null));
    }
}
