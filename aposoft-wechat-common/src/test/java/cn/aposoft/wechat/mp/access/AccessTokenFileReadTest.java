/**
 * 
 */
package cn.aposoft.wechat.mp.access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * @author Jann Liu
 *
 */
public class AccessTokenFileReadTest {

	@Test
	public void readAccessTokenFile() throws FileNotFoundException, IOException {
		File file = new File("../config/access_token.txt");
		System.out.println("file exists:" + file.exists());
		if (file.exists()) {
			System.out.println(IOUtils.toString(new FileReader(file)));
		}
	}
}
