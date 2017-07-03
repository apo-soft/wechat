/**
 * 
 */
package cn.aposoft.wechat.access;

//import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AccessToken 应用
 * 
 * @author Jann Liu
 * @since 1.0
 */
@SpringBootApplication
// @SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class AccessTokenApplication {

	/**
	 * 测试用例启动入口
	 * 
	 * @param args
	 *            传入参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccessTokenApplication.class, args);
		// 自定义启动配置
		// SpringApplication application = new
		// SpringApplication(AccessTokenApplication.class);
		// application.setBannerMode(Mode.LOG);
		// application.run(args);
	}
}
