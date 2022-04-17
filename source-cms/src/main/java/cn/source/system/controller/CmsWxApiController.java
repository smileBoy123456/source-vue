package cn.source.system.controller;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.redis.RedisCache;
import cn.source.system.utils.WxCheckUtil;
import cn.source.system.websocket.WebSocketUsers;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: cms wx api控制类
 * @author: 詹Sir
 */
@RestController
@RequestMapping("/api/cmsWxApi")
public class CmsWxApiController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CmsWxApiController.class);

    @Autowired
    private RedisCache redisCache;

    /**
     * 校验微信token
     */
    @GetMapping("/")
    public String checkSignature(String signature,String timestamp,String nonce,String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        WxCheckUtil.checkSignature(signature, timestamp, nonce);
        return echostr;
    }


    /**
     * 接收推送的数据
     */
    @PostMapping("/")
    public String subscribeProcessor(HttpServletRequest request) throws Exception {
        // 通过IO获得Document
        SAXReader reader = new SAXReader();
        Document doc = reader.read(request.getInputStream());
        // 得到xml的根节点
        Element root = doc.getRootElement();
        String toUserName = root.elementText("ToUserName");//开发者微信号
        String fromUserName = root.elementText("FromUserName");//发送方帐号（一个OpenID）
        String createTime = root.elementText("CreateTime");//消息创建时间 （整型）
        String msgType = root.elementText("MsgType");//消息类型，event
        String event = root.elementText("Event");//事件类型，subscribe(订阅)、unsubscribe(取消订阅)
        String eventKey = root.elementText("EventKey");// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
        String ticket = root.elementText("Ticket"); // 二维码的ticket，可用来换取二维码图片
        LOGGER.info("微信公众号接收信息:{},{},{},{},{},{},{}",toUserName,fromUserName,createTime,msgType,event,eventKey,ticket);
        if(msgType.equals(event)){
            if(event.equals("subscribe")){
                LOGGER.info("关注了");
                // 使用websocket打开主页
                WebSocketUsers.sendMessageToUserByText( WebSocketUsers.get( redisCache.getCacheObject(ticket)), event);
            }else if(event.equals("subscribe")){
                LOGGER.info("取消关注了");
            }else{
                // SCAN 则可以返回前端已经扫码，正在确认操作
                LOGGER.info("操作："+event);
            }
        }
        return null;
    }

}
