/**
 * 
 */
package cn.aposoft.wechat.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 读取AccessToken的本地文件示例
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AccessTokenFileReadTest {

	@Test
	public void readAccessTokenFile() throws FileNotFoundException, IOException {
		File file = new File("../../config/access_token.txt");
		System.out.println("file exists:" + file.exists());
		if (file.exists()) {
			try (Reader reader = new FileReader(file)) {
				System.out.println(IOUtils.toString(reader));
			}
		}
	}

	@Test
	public void readAccountConfigFile() throws FileNotFoundException, IOException {
		File file = new File("../../config/mp_account.txt");
		System.out.println("file exists:" + file.exists());
		if (file.exists()) {
			try (Reader reader = new FileReader(file)) {
				System.out.println(IOUtils.toString(reader));
			}
		}
	}

}
