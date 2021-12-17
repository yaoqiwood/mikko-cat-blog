package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

/**
* <p>
	* ${table.comment!} 服务实现类
	* </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

	/**
	* 用于构造搜索接口的条件
	* @param var
	* @return
	*/
	@Override
	public QueryWrapper<${entity}> buildWrapper(${entity} var) {
		return null;
	}
}

</#if>
