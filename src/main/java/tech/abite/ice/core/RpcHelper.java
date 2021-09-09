package tech.abite.ice.core;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.Setter;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;

@Setter
public class RpcHelper<T> {
    private ApplicationConfig applicationConfig = new ApplicationConfig();
    private RegistryConfig registryConfig = new RegistryConfig();
    ReferenceConfig<T> referenceConfig = new ReferenceConfig();
    String zkAddress;
    /**
     * 构造函数
     */
    private RpcHelper(String zkAddress, String applicationName,String version,String group) {
        this.zkAddress = zkAddress;
        applicationConfig.setName(applicationName);
        registryConfig.setAddress(zkAddress);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setGroup(group);
        referenceConfig.setVersion(version);
        referenceConfig.setRegistry(registryConfig);
    }

    /**
     * 构造 RPC 调用实例
     *
     * @param interfaceClass
     * @return
     */
    public T build(Class<T> interfaceClass) {
        referenceConfig.setInterface(interfaceClass);
        return referenceConfig.get();
    }

    /**
     * 泛化调用
     * @param interfaceName
     * @param method
     * @param arg
     * @param value
     * @return
     */
    public String invoke(String interfaceName, String method, String[] arg, Object[] value){
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setGeneric("true");
        ReferenceConfigCache referenceConfigCache = ReferenceConfigCache.getCache(zkAddress);
        GenericService genericService = (GenericService) referenceConfigCache.get(referenceConfig);
        Object result = genericService.$invoke(method, arg, value);
        return JSON.toJSONString(result);
    }
    /**
     * 泛化调用
     * @param interfaceName
     * @param method
     * @param arg
     * @param json
     * @return
     */
    public String invoke(String interfaceName, String method, String[] arg, String json){
        referenceConfig.setInterface(interfaceName);
        referenceConfig.setGeneric("true");
        ReferenceConfigCache referenceConfigCache = ReferenceConfigCache.getCache(zkAddress);
        GenericService genericService = (GenericService) referenceConfigCache.get(referenceConfig);
        Object[] value = new Object[]{JSONUtil.parse(json)};
        Object result = genericService.$invoke(method, arg, value);
        return JSON.toJSONString(result);
    }

}
