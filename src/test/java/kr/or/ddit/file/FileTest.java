/**
 * 
 */
package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;

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

	@Test
	public void getFileTest() {
		/***Given***/
		String contentDispositon = "form-data; name=\"img\"; filename=\"AA.19067065.1.jpg\"";

		/***When***/
		String fileName = FileUpdloadUtil.getFilename(contentDispositon);
		
		/***Then***/
		assertEquals("AA.19067065.1.jpg",fileName);
	}

}
