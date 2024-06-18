import com.bench.bms.entity.Car;
import com.bench.bms.mapper.CarMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author bench
 * @Date 2024/06/18 09:12
 **/

@SpringBootTest(classes = com.bench.bms.BmsApplication.class)
public class MapperTest {

    @Resource
    private CarMapper carMapper;

    @Test
    public void testCar(){
        List<Car> carList = carMapper.selectAllCars();
        carList.forEach(System.out::println);
    }


}
