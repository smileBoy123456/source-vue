package cn.source.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作人类别
 *
 * @author ruoyi
 */
public enum AccessType {
    /**
     * PC
     */
    PC,

    /**
     * 手机端用户
     */
    H5,

    /**
     * 小程序
     */
    MINI,

    /**
     * APP
     */
    APP;

    /**
     * 获取枚举值常量列表
     * @return
     */
    public static List<String>  getEumValueList() {
        List<String> list=new ArrayList<String>();
        for(Object object:AccessType.values()) {
            list.add(object.toString());
        }
        return list;
    }
}
