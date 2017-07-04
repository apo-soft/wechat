package cn.aposoft.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 弃用
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * 测试用例启动入口
	 * 
	 * @param args
	 *            传入参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		// 自定义启动配置
		// SpringApplication application = new
		// SpringApplication(AccessTokenApplication.class);
		// application.setBannerMode(Mode.LOG);
		// application.run(args);
	}
}
