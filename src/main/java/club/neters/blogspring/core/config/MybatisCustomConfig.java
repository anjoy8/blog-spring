package club.neters.blogspring.core.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mybatis custom Config
 *
 * @author laozhang
 * @date 2021/06/12
 */
@Configuration
@EnableTransactionManagement
@MapperScan("club.neters.blogspring.mapper")
public class MybatisCustomConfig {

}
