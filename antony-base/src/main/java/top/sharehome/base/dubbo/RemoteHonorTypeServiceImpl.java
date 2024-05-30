package top.sharehome.base.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import top.sharehome.base.api.RemoteHonorTypeService;
import top.sharehome.base.domain.Honor;
import top.sharehome.base.mapper.HonorMapper;

/**
 * 荣誉类型服务
 *
 * @author AntonyCheng
 */
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteHonorTypeServiceImpl implements RemoteHonorTypeService {

    private final HonorMapper honorMapper;

    /**
     * 根据ID获取荣誉类型服务
     *
     * @param honorTypeId 荣誉类型id
     * @return 荣誉类型
     */
    @Override
    public String queryHonorTypeNameById(Long honorTypeId) {
        Honor honor = honorMapper.selectById(honorTypeId);
        return honor.getHonorTypeName();
    }

}
