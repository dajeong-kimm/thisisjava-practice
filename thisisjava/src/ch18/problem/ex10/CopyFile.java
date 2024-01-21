package ch18.problem.ex10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) {

		try {
			Scanner nsc = new Scanner(System.in);
			
			System.out.println("원본 파일 경로: ");
			String originalFilePath = nsc.nextLine();
			
			System.out.println("복사 파일 경로: ");
			String targetFilePath = nsc.nextLine();
			
			File originalFile = new File(originalFilePath);
			if(!originalFile.exists()) {
				System.out.println("원본파일이존재하지않음");
				System.exit(0);
			}
			
			File targetFile = new File(targetFilePath);
			File parentFile = targetFile.getParentFile();
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(originalFilePath));
			
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));
			
			byte[] data = new byte[1024];
			int num = -1;
			while(true) {
				num = bis.read(data);
				if(num == -1) break;
				bos.write(data,0,num);
			}
			System.out.println("복사가 완료되었습니다. ");
			
			bis.close();
			bos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
