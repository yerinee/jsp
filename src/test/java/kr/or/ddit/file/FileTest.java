/**
 * 
 */
package kr.or.ddit.file;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUpdloadUtil;

/**
* FileTest.java
*
* @author PC-18
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC-18 최초 생성
*
* </pre>
*/
public class FileTest {
	private static final Logger logger = LoggerFactory.getLogger(FileTest.class);
	@Test
	public void getFileTest() {
		/***Given***/
		String contentDispositon = "form-data; name=\"img\"; filename=\"AA.19067065.1.jpg\"";

		/***When***/
		String fileName = FileUpdloadUtil.getFilename(contentDispositon);
		
		/***Then***/
		assertEquals("AA.19067065.1.jpg",fileName);
	}
	
	@Test
	public void UUIDTest() {
		/***Given***/

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {} " , uuid);
		
		/***Then***/
	}
	
	@Test
	public void fileNameTest() {
		
		/***Given***/
		String fileName = "2019.png";

		/***When***/
		String extension = FileUpdloadUtil.getExtenstion(fileName);
		
		/***Then***/
		assertEquals("png",extension);
	}

}
