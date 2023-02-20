package yokiware.controller;

import org.apache.log4j.Logger;
import yokiware.entity.Audit;
import yokiware.service.AuditService;
import yokiware.service.impl.AuditServiceImpl;
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
@WebServlet("/audit/*")
public class AuditController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(AuditController.class);
    private final AuditService auditService = new AuditServiceImpl();
    private List<Audit> auditList;
    private Audit audit;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String[] uriParts = requestURI.split("/");
        // 获取所有用户信息
        if (uriParts.length == 3 || (uriParts.length == 4 && uriParts[3].isEmpty())) {
            auditList = auditService.getAll();
            if (auditList != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回所有用户信息", auditList));
            } else
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_ERR, "GET失败，返回null", null));
        }
        // 获取单个用户信息
        else if (uriParts.length == 4) {

            int userId = Integer.parseInt(uriParts[3]);

            audit = auditService.getById(userId);
            if (audit != null) {
                JSONUtil.responseOutWithJson(resp, new Result(Code.GET_OK, "GET成功,返回单个用户信息", audit));
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
        if (auditService.delById(Integer.parseInt(req.getParameter("id")))) {
            JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_OK, "DELETE成功", null));
        } else JSONUtil.responseOutWithJson(resp, new Result(Code.DELETE_ERR, "DELETE失败", null));
    }
}