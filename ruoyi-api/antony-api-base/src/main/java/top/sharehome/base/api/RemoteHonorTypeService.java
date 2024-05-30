package top.sharehome.base.api;


/**
 * 荣誉类型服务
 *
 * @author AntonyCheng
 */
public interface RemoteHonorTypeService {

    /**
     * 根据ID获取荣誉类型服务
     *
     * @param honorTypeId 荣誉类型id
     * @return 荣誉类型
     */
    String queryHonorTypeNameById(Long honorTypeId);

}
