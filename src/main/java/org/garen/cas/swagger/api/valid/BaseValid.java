package org.garen.cas.swagger.api.valid;

/**
 * 验证父类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:09
 * @since v1.0
 */
public class BaseValid {
    /**
     * 不能为空
     */
    public final String NOT_EMPTY = "不能为空";

    /**
     * str不能为空
     *
     * @param str
     * @return
     */
    public String emptyMsg(String str){
        return str + NOT_EMPTY;
    }

    /**
     * 参数不能为空
     *
     * @return
     */
    public String paramNullMsg(){
        return "参数" + NOT_EMPTY;
    }
}
