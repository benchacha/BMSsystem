import com.bench.bms.infra.repository.MybatisConfig;
import com.bench.bms.infra.repository.entity.CarPo;
import com.bench.bms.infra.repository.entity.RulePo;
import com.bench.bms.infra.repository.mapper.CarPoMapper;
import com.bench.bms.infra.repository.mapper.RulePoMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/17 21:37
 **/

@EnableAutoConfiguration
@SpringBootTest(classes = MybatisConfig.class)
//@ContextConfiguration(classes = MybatisConfig.class)
public class CarPoMapperTest {

    @Resource
    private CarPoMapper carPoMapper;


    @Resource
    private RulePoMapper rulePoMapper;

    @Test
    public void test1(){
        CarPo carPo = carPoMapper.searchByCarNumber(1);
        System.out.println(carPo);
//        carPoMapper.ListAllCar();
    }

    @Test
    public void test2(){
        List<CarPo> carPoList = carPoMapper.ListAllCar();
//        System.out.println(carPo);
//        carPoMapper.ListAllCar();
        carPoList.forEach(System.out::println);
    }

    @Test
    public void test3(){
        List<RulePo> rulePoList = rulePoMapper.selectRules();
//        System.out.println(carPo);
//        carPoMapper.ListAllCar();
        rulePoList.forEach(System.out::println);
    }
}
