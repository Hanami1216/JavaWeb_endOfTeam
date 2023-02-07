import net.sf.json.JSONObject;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/7  8:32
 */
public class JSONTest {
    public static void main(String[] args) {
        createJson();
    }

    private static void createJson() {
        JSONObject obj = new JSONObject();
        obj.put("name", "John");
        obj.put("sex", "male");
        obj.put("age", 22);
        obj.put("is_student", true);
        obj.put("hobbies", new String[]{"hiking", "swimming"});
        //调用toString()方法可直接将其内容打印出来
        System.out.println(obj.toString());

        JSONObject jsonObject = JSONObject.fromObject("123");
        System.out.println(jsonObject.toString());
    }
}
