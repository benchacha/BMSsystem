package com.bench.bms.infra.repository.impl;

import com.bench.bms.domain.model.WarnDo;
import com.bench.bms.infra.repository.WarnRepository;
import com.bench.bms.infra.repository.converter.WarnPoConverter;
import com.bench.bms.infra.repository.entity.WarnPo;
import com.bench.bms.infra.repository.mapper.WarnPoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @Author bench
 * @Date 2024/06/18 14:33
 **/

@Service
public class WarnRepositoryImpl implements WarnRepository {

    @Resource
    private WarnPoConverter warnPoConverter;

    @Resource
    private WarnPoMapper warnPoMapper;

    @Override
    public boolean saveWarn(WarnDo warnDo) {

//        1、利用warnPoConverter将warnDo转化为warnPo
        WarnPo warnPo = warnPoConverter.toPo(warnDo);
//        2、利用warnPoMapper将warnPo保存到数据库当中。

        return warnPoMapper.save(warnPo);
    }
}
