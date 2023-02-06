package yokiware.util;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/6  15:30
 */
public class JSONUtil {
    /**
     * 以JSON格式输出
     *
     * @param response
     */
    public static void responseOutWithJson(HttpServletResponse response,
                                           Object responseObject) {
        //将实体对象转换为JSON Object转换
        JSONObject responseJSONObject = JSONObject.fromObject(responseObject);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter out = response.getWriter()) {
            out.append(responseJSONObject.toString());
            //logger.debug("返回是\n");
            //logger.debug(responseJSONObject.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
