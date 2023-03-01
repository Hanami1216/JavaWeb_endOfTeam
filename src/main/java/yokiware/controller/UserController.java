package yokiware.controller;

import com.google.gson.Gson;
import yokiware.entity.User;
import yokiware.service.UserService;
import yokiware.service.impl.UserServiceImpl;
import yokiware.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/5  14:12
 */
@WebServlet("/api/user/*")
public class UserController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String requestURI = req.getRequestURI();
        String[] uriParts = requestURI.split("/");


        // 获取所有用户信息
        List<User> userList;
        if (uriParts.length == 4 || (uriParts.length == 5 && uriParts[4].isEmpty())) {
            userList = userService.getAll();
            if (userList != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回所有用户信息", userList));
            } else {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));

            }

        }
        // 获取单个用户信息
        else if (uriParts.length == 5) {

            int userId = Integer.parseInt(uriParts[4]);

            user = userService.getById(userId);
            if (user != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回单个用户信息", user));
            } else {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
            }
        }
        // 恢复null
        user = null;
        userList = null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        user = new Gson().fromJson(bufferedReader, User.class);
        if (user != null) {
            userService.addUser(user);
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "ADD成功,返回null", null));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "ADD失败，返回null", null));
        user = null;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        user = new Gson().fromJson(bufferedReader, User.class);
        if (user != null) {
            userService.modifyById(user);
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "UPDATE成功,返回null", null));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "UPDATE失败，返回null", null));
        user = null;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userService.delById(Integer.parseInt(req.getParameter("id")))) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_OK, "DELETE成功", null));
        } else JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_ERR, "DELETE失败", null));
    }

}
