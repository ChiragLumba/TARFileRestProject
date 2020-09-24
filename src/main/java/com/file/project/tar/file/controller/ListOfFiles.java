package com.file.project.tar.file.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ListOfFiles {

	/**
	 * List all files from a directory and its sub directories
	 * 
	 * @param directoryName to be listed
	 */
	public List<String> listFiles(String directoryName) {
		List<String> fileList = new ArrayList<String>();
		File folder = new File(directoryName);
		File[] listOfFiles = folder.listFiles();
		try {
//			TarArchiveInputStream fin = new TarArchiveInputStream(new FileInputStream(directoryName));
//			TarArchiveEntry entry;
            for(File file : listOfFiles) {
            	if(file!= null && file.getName().endsWith(".tar")) {
            		fileList.add(file.getName());
            		
            	}
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}

}
