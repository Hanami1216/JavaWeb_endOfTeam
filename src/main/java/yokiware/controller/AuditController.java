package yokiware.controller;

import com.google.gson.Gson;
import yokiware.entity.Audit;
import yokiware.entity.User;
import yokiware.service.AuditService;
import yokiware.service.UserService;
import yokiware.service.impl.AuditServiceImpl;
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
@WebServlet("/api/audit/*")
public class AuditController extends HttpServlet {

    private final AuditService auditService = new AuditServiceImpl();
    private List<Audit> auditList;
    private Audit audit;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestURI = req.getRequestURI();
        String[] uriParts = requestURI.split("/");
        // 获取所有用户信息
        if (uriParts.length == 4 || (uriParts.length == 5 && uriParts[4].isEmpty())) {
            auditList = auditService.getAll();
            if (auditList != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回所有用户信息", auditList));
            } else
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
        }
        // 获取单个用户信息
        else if (uriParts.length == 5) {

            int userId = Integer.parseInt(uriParts[3]);

            audit = auditService.getById(userId);
            if (audit != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回单个用户信息", audit));
            } else
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
        }
        auditList = null;
        audit = null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader = req.getReader();
        audit = new Gson().fromJson(bufferedReader, Audit.class);
        if (audit != null) {
            auditService.addAudit(audit);
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "ADD成功,返回null", true));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "ADD失败，返回null", false));
        audit = null;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader = req.getReader();
        audit = new Gson().fromJson(bufferedReader, Audit.class);
        if (audit != null) {
            if (auditService.modifyById(audit)) {
                UserService userService = new UserServiceImpl();
                if (userService.addUser(new User(audit.getId(), audit.getName(), audit.getSex(), audit.getAge(), audit.getAddress(), audit.getPower(), audit.getPassword()))) {
                    JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_OK, "UPDATE成功,返回null", true));
                } else JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "UPDATE失败，返回null", false));
            } else JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "UPDATE失败，返回null", false));
        } else
            JSONUtil.responseOutWithJson(resp, new Result(Code.UPDATE_ERR, "UPDATE失败，返回null", false));
        audit = null;
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (auditService.delById(Integer.parseInt(req.getParameter("id")))) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_OK, "DELETE成功", true));
        } else JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_ERR, "DELETE失败", false));

    }
}
