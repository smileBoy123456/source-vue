package cn.source.web.controller.common;

import cn.source.common.config.RuoYiConfig;
import cn.source.common.constant.Constants;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.redis.RedisCache;
import cn.source.common.utils.sign.Base64;
import cn.source.common.utils.sms.DySmsUtil;
import cn.source.common.utils.uuid.CodeUtil;
import cn.source.common.utils.uuid.IdUtils;
import cn.source.system.service.ISysConfigService;
import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 验证码操作处理
 *
 * @author ruoyi
 */
@RestController
public class CaptchaController
{

    private final static Logger logger= LoggerFactory.getLogger(CaptchaController.class);

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysConfigService configService;

    @Value("${sms.id}")
    private  String accessKeyId;

    @Value("${sms.pwd}")
    private  String accessKeySecret;

    @Value("${sms.template}")
    private  String accessKeytemplate;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode(HttpServletResponse response) throws IOException
    {
        AjaxResult ajax = AjaxResult.success();
        boolean captchaOnOff = configService.selectCaptchaOnOff();
        ajax.put("captchaOnOff", captchaOnOff);
        if (!captchaOnOff)
        {
            return ajax;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = RuoYiConfig.getCaptchaType();
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }

    /**
     * 获取发送手机验证码
     */
    @GetMapping(value = "/api/captchaSms")
    public boolean captchaSms(String loginName)
    {
        // 当验证码失效才进行操作
        if(redisCache.getCacheObject(loginName) == null){
            String code = CodeUtil.getCapthCode();
            // 将验证码限制参数放到缓存里 10分钟过期，10分钟后才能再次发短信
            redisCache.setCacheObject(loginName, code , 10,TimeUnit.MINUTES);
            JSONObject obj = new JSONObject();
            obj.put("code", code);
            // logger.info(code);
            // 云信短信
            DySmsUtil.sendSms(loginName, obj,accessKeyId,accessKeySecret,accessKeytemplate);
            return true;
        }else{
            return false;
        }
    }
}
