package blog.synths.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.synths.web.service.FileuploadService;

@Controller
public class FileuploadController {
	@Autowired
	private FileuploadService fileuploadService;

	// file upload form
	@RequestMapping(value = "/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		return "fileAdd";
	}

	// file upload action
	@RequestMapping(value = "/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileRequest) {
		System.out.println(fileRequest);
		// 1. 파일에 폴더를 지정하는 로직
		// 2. 저장된 파일의 이름과 파일 제목을
		fileuploadService.fileupload(fileRequest);
		return "";
	}
}
