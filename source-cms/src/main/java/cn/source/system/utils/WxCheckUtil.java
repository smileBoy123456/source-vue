package cn.source.system.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 签名认证工具类
 * @ClassName:  WxCheckUtil
 *
 */
public class WxCheckUtil {

	// 与接口配置信息中的Token要一致
    private static String token = "sourcebyte";

    /**
     * 验证签名
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[] { token, timestamp, nonce };
        // 将token、timestamp、nonce三个参数进行字典序排序
        // Arrays.sort(arr);
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信

        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
    public static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

/*    *//**
     * 获取AccessToken
     * @return
     *//*
    public static String obtainAccessToken(){
        String G_APPID = “公众号的APPID”;
        String G_SECRET = “公众号的SECRET”;
        String tokenData = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+G_APPID+"&secret="+G_SECRET;
        // 返回的用户信息json字符串
        JSONObject jsonObject = httpRequestUtil(tokenData);
        return String.valueOf(jsonObject.get("access_token"));
    }

    *//**
     * 获取订阅用户的openid和unionid
     * @param accessToken
     * @param openId
     * @return
     *//*
    public static OpenUnionIdRelationDO obtainUserDetail(String accessToken,String openId){
        String openInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid="+openId+"&lang=zh_CN";
        JSONObject userDetail = httpRequestUtil(openInfoUrl);
        String openid = userDetail.getString("openid");
        Integer subscribeTime = userDetail.getInteger("subscribe_time");
        String unionid = userDetail.getString("unionid");

        OpenUnionIdRelationDO openDO = new OpenUnionIdRelationDO();
        openDO.setOpenId(openid);
        openDO.setUnionId(unionid);
        // 时间类型转换 10位时间戳转 yyyy-MM-dd HH:mm:ss
        String st = "";
        if (null != subscribeTime){
            st = DateUtils.timestampToString(subscribeTime);
        }
        openDO.setSubscribeTime(st);
        openDO.setCreateTime(new Date());
        return openDO;
    }

    *//**
     * 给关注该公众好的用户发送信息
     * @throws Exception
     *//*
    public static void sendTemplateInfo() throws Exception{

        //获取小程序accessToken
        String accessToken = obtainAccessToken();
        //消息推送接口
        String path = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + accessToken;

        //封装参数
        JSONObject jsonData = new JSONObject();
        jsonData.put("touser", "公众号openid");
        jsonData.put("template_id", "公众号消息模板id");
        JSONObject miniprogram = new JSONObject();
        miniprogram.put("appid","小程序ID");
        miniprogram.put("pagepath","小程序调转路径");
        jsonData.put("miniprogram",miniprogram);

        JSONObject data = new JSONObject();

        JSONObject first = new JSONObject();
        first.put("value","测试购票支付详情！");
        first.put("color","#173177");

        JSONObject keyword1 = new JSONObject();
        keyword1.put("value","2112323832748239");
        keyword1.put("color","#173177");

        JSONObject keyword2 = new JSONObject();
        keyword2.put("value","2022-12-22 00:00:00");
        keyword2.put("color","#173177");

        JSONObject keyword3 = new JSONObject();
        keyword3.put("value","199.56元");
        keyword3.put("color","#173177");

        JSONObject keyword4 = new JSONObject();
        keyword4.put("value","微信支付");
        keyword4.put("color","#173177");

        JSONObject remark = new JSONObject();
        remark.put("value","温馨提示：请不要爽约哦！");
        remark.put("color","#173177");

        data.put("first",first);
        data.put("keyword1",keyword1);
        data.put("keyword2",keyword2);
        data.put("keyword3",keyword3);
        data.put("keyword4",keyword4);
        data.put("remark",remark);
        jsonData.put("data",data);
        HttpUtil.post(path, jsonData.toJSONString());
    }*/

}
