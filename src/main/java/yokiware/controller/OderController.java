package yokiware.controller;

import com.google.gson.Gson;
import yokiware.entity.Oder;
import yokiware.service.OderService;
import yokiware.service.impl.OderServiceImpl;
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
@WebServlet("/api/oder/*")
public class OderController extends HttpServlet {

    private final OderService oderService = new OderServiceImpl();
    private Oder oder;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String requestURI = req.getRequestURI();
        String[] uriParts = requestURI.split("/");

        // 获取所有用户信息
        List<Oder> oderList;
        if (uriParts.length == 4 || (uriParts.length == 5 && uriParts[4].isEmpty())) {
            oderList = oderService.getAll();
            if (oderList != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回所有订单信息", oderList));
            } else {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));

            }

        }
        // 获取单个用户信息
        else if (uriParts.length == 5) {

            int userId = Integer.parseInt(uriParts[3]);

            oder = oderService.getById(userId);
            if (oder != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回单个用户信息", oder));
            } else {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
            }
        }
        // 恢复null
        oder = null;
        oderList = null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        oder = new Gson().fromJson(bufferedReader, Oder.class);
        if (oder != null) {
            oderService.addUser(oder);
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "ADD成功,返回null", null));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "ADD失败，返回null", null));
        oder = null;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();
        oder = new Gson().fromJson(bufferedReader, Oder.class);
        if (oder != null) {
            oderService.modifyById(oder);
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "UPDATE成功,返回ture", true));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "UPDATE失败，返回false", false));
        oder = null;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (oderService.delById(Integer.parseInt(req.getParameter("id")))) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_OK, "DELETE成功", null));
        } else JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_ERR, "DELETE失败", null));
    }

}
