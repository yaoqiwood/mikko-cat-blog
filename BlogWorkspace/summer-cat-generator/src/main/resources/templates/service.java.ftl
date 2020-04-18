package ${package.Service};

import ${package.Entity}.${entity};
<#--import ${superServiceClassPackage};-->
import meme.cat.basic.service.BaseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
* <p>
	* ${table.comment!} 服务类
	* </p>
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
interface ${table.serviceName} : BaseService<${entity}>
<#else>
public interface ${table.serviceName} extends BaseService<${entity}> {
	QueryWrapper<${entity}> buildWrapper(${entity} var);
}
</#if>
