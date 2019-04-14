package com.mobiquityinc.file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mobiquityinc.exc.APIException;

public class FileRead {

	public List<String> readFile(String filePath) {
		final List<String> lineList = new ArrayList<String>();
		if (!(filePath == null || filePath.isEmpty())) {
			if (isFileExist(filePath)) {
				FileReader fileReader;
				try {
					InputStream inputStream       = new FileInputStream(filePath);
					Reader      inputStreamReader = new InputStreamReader(inputStream, "windows-1252");
					
//					fileReader = new FileReader(filePath);
					BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						lineList.add(line);
					}
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			
			} else {
				throw new APIException("file is not exist");
			}
		} else {
			throw new APIException("file path is null or empty");
		}
		return lineList;
	}

	public boolean isFileExist(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}
}
