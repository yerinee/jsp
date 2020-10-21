package kr.or.ddit.fileupload;

public class FileUpdloadUtil {
	
	// form-data; name="img"; filename="2018-03-16_10;50;49.png
	// --> sally.png
	

	// FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		
//		String cont = contentDisposition;
		//String cont = "form-data; name='img'; filename='2018-03-16_10;50;49.png'";
		
		String[] conts = contentDisposition.split("; ");
		String[] contss;

		for(int i=0; i<conts.length;i++) {
			contss = conts[i].split("=");

			if(contss[0].equals("filename")) {				
				return contss[1].replace("\"", "");
			}
		
		}
		return "";
	}
	
}
