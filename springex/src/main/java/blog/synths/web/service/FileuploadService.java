package blog.synths.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import blog.synths.web.FileRequest;

@Service
public class FileuploadService {
	public int fileupload(FileRequest fileRequest) {
		//ファイルの拡張子を分理させる。
		MultipartFile file = fileRequest.getFile();
		String fileName = file.getOriginalFilename();
		int pos = fileName.lastIndexOf(".");
		String ext = fileName.substring(pos+1);
		System.out.println("ext : " + ext);
		
		//API UUID = ランダム文字列を生成するAPI
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		
		//生成された文字列で「-」は要らないので「-」を空白にする。
		String name = uuid.toString().replace("-", "");
		System.out.println(name);
		
		//そのように生成されたファイル名に拡張子を付ければ完成。
		String finalFileName = name+"."+ext;
		System.out.println(finalFileName);
		
		//経路を指定して保存する。
		File uploadFile = new File("c:/upload/"+name+"."+ext);
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Daoを呼び出してDBにアップロードする。
		FileVo fileVo = new FileVo();
		fileVo.setFileTitle(fileRequest.getFileTiltle());
		fileVo.setFilePath("c:/upload/"+name+"."+ext);
		//FileDao.insertFile(fileVo);
		
		return 0;
	}
}
