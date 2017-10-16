package blog.synths.web;

import org.springframework.web.multipart.MultipartFile;

public class FileRequest {
	private String fileTiltle;
	private MultipartFile file;

	public String getFileTiltle() {
		return fileTiltle;
	}

	public void setFileTiltle(String fileTiltle) {
		this.fileTiltle = fileTiltle;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileRequest [fileTiltle=" + fileTiltle + ", file=" + file + "]";
	}

	public FileRequest(String fileTiltle, MultipartFile file) {
		super();
		this.fileTiltle = fileTiltle;
		this.file = file;
	}

	public FileRequest() {
		super();
	}
}
