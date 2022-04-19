package cn.source.system.controller;

import cn.source.common.core.controller.BaseController;
import cn.source.common.core.redis.RedisCache;
import cn.source.common.utils.DateUtils;
import cn.source.common.utils.StringUtils;
import cn.source.system.utils.WxUtil;
import cn.source.system.websocket.WebSocketUsers;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Value("${sms.appId}")
    private String APPID;

    @Value("${sms.secret}")
    private String SECRET;

    @Value("${sms.accessTokenKey}")
    private String accessTokenKey;

    /**
     * 校验微信token
     */
    @GetMapping("/")
    public String checkSignature(String signature,String timestamp,String nonce,String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        WxUtil.checkSignature(signature, timestamp, nonce);
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
        String event = root.elementText("Event");//事件类型，subscribe(订阅)、unsubscribe(取消订阅),SCAN
        String eventKey = root.elementText("EventKey");// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
        String ticket = root.elementText("Ticket"); // 二维码的ticket，可用来换取二维码图片
        LOGGER.info("微信公众号接收信息:{},{},{},{},{},{},{}",toUserName,fromUserName,createTime,msgType,event,eventKey,ticket);
        // 定义变量判断是否已关注，已经关注则自动登录，否则等待subscribe关注事件
        if(StringUtils.isNotEmpty(ticket)){
           Object token = redisCache.getCacheObject(accessTokenKey);
           Map map = WxUtil.obtainUserDetail(token.toString(), fromUserName);
           String ticketCacheKey= DateUtils.getDate()+":"+ticket;
           String sessionId = redisCache.getCacheObject(ticketCacheKey);
           // sessionId可能已经失效，则不发消息
           if(StringUtils.isNotNull(sessionId)){
               WebSocketUsers.sendMessageToUserByText( WebSocketUsers.get(sessionId), map.get("subscribe").toString());
           }
        }
        return null;
    }

    /**
     * 获取AccessToken
     */
    @GetMapping("/getAccessToken")
    public Object getAccessToken(){
        // 2000上限
        Object token = redisCache.getCacheObject(accessTokenKey);
        if(StringUtils.isNull(token)){
            token = WxUtil.obtainAccessToken(APPID, SECRET);
            redisCache.setCacheObject(accessTokenKey,token,30,TimeUnit.MINUTES);
        }
        return token;
    }

}
