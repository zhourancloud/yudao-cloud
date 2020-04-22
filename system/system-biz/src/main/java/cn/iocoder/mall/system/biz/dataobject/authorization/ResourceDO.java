package cn.iocoder.mall.system.biz.dataobject.authorization;

import cn.iocoder.common.framework.dataobject.DeletableDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 资源实体
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "resource")
public class ResourceDO extends DeletableDO {

    /**
     * 资源编号
     */
    private Integer id;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 权限标识
     *
     * 一般格式为：${系统}:${模块}:${操作}
     * 例如说：system:admin:add，即 system 服务的添加管理员。
     *
     * 当我们把该 ResourceDO 赋予给角色后，意味着该角色有该资源：
     * - 对于后端，配合 @RequiresPermissions 注解，配置 API 接口需要该权限，从而对 API 接口进行权限控制。
     * - 对于前端，配合前端标签，配置按钮是否展示，避免用户没有该权限时，结果可以看到该操作。
     */
    private String permission;
    /**
     * 资源类型
     *
     * 关联 {@link Resource}
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 父级资源编号
     *
     * 关联：{@link ResourceDO#getId()}
     */
    private Integer pid;
    /**
     *
     *
     * 目前当且仅当资源类型为【菜单】时，才会生效，即 handler 配置为界面 URL ，或者前端组件名，或者前端的路由。
     */
    private String handler;
    /**
     * 图标
     *
     * 目前当且仅当资源类型为【菜单】时，才会生效
     */
    private String icon;
    /**
     * 权限标识数组，使用逗号分隔。
     *
     * 例如：system:admin:add
     * 推荐格式为 ${系统}:${模块}:${操作}
     */
    private String permissions;

}