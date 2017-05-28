package zarazio.travel.android.bean;

import org.springframework.web.multipart.MultipartFile;

public class PictureFileDTO {

	private MultipartFile pictureFile;
	private String fileName;
	private String filePath;
	public MultipartFile getPictureFile() {

		return pictureFile;

	}

	public void setPictureFile(MultipartFile pictureFile) {

		this.pictureFile = pictureFile;

	}

	public String getFileName() {

		return fileName;

	}

	public void setFileName(String fileName) {

		this.fileName = fileName;

	}

	public String getFilePath() {

		return filePath;

	}

	public void setFilePath(String filePath) {

		this.filePath = filePath;

	}

}
