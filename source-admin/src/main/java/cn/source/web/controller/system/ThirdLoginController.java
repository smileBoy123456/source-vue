package cn.source.web.controller.system;

import cn.source.common.constant.Constants;
import cn.source.common.core.controller.BaseController;
import cn.source.common.core.domain.AjaxResult;
import cn.source.common.core.domain.entity.SysUser;
import cn.source.common.core.domain.model.LoginBody;
import cn.source.common.core.domain.model.LoginUser;
import cn.source.common.core.redis.RedisCache;
import cn.source.common.utils.SecurityUtils;
import cn.source.common.utils.StringUtils;
import cn.source.framework.web.service.SysLoginService;
import cn.source.framework.web.service.SysPermissionService;
import cn.source.framework.web.service.TokenService;
import cn.source.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * 三方登录验证
 *
 * @author ruoyi
 */
@RequestMapping("/api")
@RestController
public class ThirdLoginController extends BaseController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 三方登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/thirdLogin")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        return loginService.thirdLogin(loginBody.getUsername(), loginBody.getPassword());
    }


    /**
     * 手机注册/登录
     */
    @PostMapping("/thirdRegister")
    public AjaxResult thirdRegister(HttpServletRequest request,
                                    @RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        String msg = "登录成功";
        if (StringUtils.isEmpty(loginBody.getUsername()) || StringUtils.isEmpty(loginBody.getCode())){
            msg = "用户名/验证码不能为空";
            return error(msg);
        }
        // 首先验证验证码是否正确
        if(redisCache.getCacheObject(loginBody.getUsername()) == null || !redisCache.getCacheObject(loginBody.getUsername()).equals(loginBody.getCode())){
            msg = "验证码过期/错误";
            return error(msg);
        }
        // 验证码正确则判断是否为新用户
        SysUser sysUser = userService.selectUserByUserName(loginBody.getUsername());
        // 不是新用户，创建用户
        if(sysUser == null){
            sysUser = new SysUser();
            sysUser.setUserName(loginBody.getUsername());
            sysUser.setNickName(loginBody.getUsername());
            sysUser.setPassword(loginBody.getPassword());
            sysUser.setPhonenumber(loginBody.getUsername());
            sysUser.setPassword(SecurityUtils.encryptPassword(loginBody.getUsername()));
            userService.registerUser(sysUser);
        //  保存完用户后，还需要设置用户的角色，部门与岗位
        }
        // 生成token
        LoginUser loginUser = new LoginUser(sysUser,null);
        String token = tokenService.createToken(loginUser);
        ajax.put(Constants.TOKEN, token);
        ajax.put("loginUser", loginUser);
        return ajax;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

}
