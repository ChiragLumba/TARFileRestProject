package com.file.project.tar.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.file.project.tar.file.utility.ServiceConstants;

/** 
 * Providing the request mapping for the application.
 * Based on Aggregation pattern, this will be the parent mapping
 * @author chirag
 *
 */

@RestController
@Service
@RequestMapping(path = "/file", method = RequestMethod.GET)
public class FileController {

	@Autowired
	ImportFile importFileController;

	@Autowired
	PullFile pullFileController;

	@Autowired
	ListOfFiles listOfFiles;
	
	/** 
	 * Providing the request mapping for importing of files .
	 * The files imported will be converted to TAR File
	 * @author chirag
	 *
	 */

	@RequestMapping(path = "/import", method = RequestMethod.GET)
	public ResponseEntity<String> returnFile(@RequestParam(value ="importdirectory") String directoryName) {

		try {
			importFileController.compressedFile(directoryName);
		} catch (Exception e) {
			return ResponseEntity.status(ServiceConstants.HTTP_Status_Code).body(e.getMessage());
		}
		return ResponseEntity.ok().body(ServiceConstants.Import_Response_Message);

	}
	
	/** 
	 * Providing the request mapping to extract the files.
	 * The files will be extracted from the TAR file present in the directory.
	 * @author chirag
	 *
	 */

	@RequestMapping(path = "/pull", method = RequestMethod.GET)
	public ResponseEntity<String> decompressedFile(@RequestParam(value ="pulldirectory") String directoryName) {
		try {
			pullFileController.decompressTarFile(directoryName);
		} catch (Exception e) {
			return ResponseEntity.status(ServiceConstants.HTTP_Status_Code).body(e.getMessage());
		}
		return ResponseEntity.ok().body(ServiceConstants.Pull_Response_Message);

	}
	
	/** 
	 * Providing the request mapping to provide the list of the files
	 * The list of the files present under the given directory will be shown.
	 * @author chirag
	 *
	 */

	@RequestMapping(path = "/listOfFiles", method = RequestMethod.GET)
	public void listOfFiles(@RequestParam(value="listFileDirectory") String name) {
		listOfFiles.listFiles(name);

	}

}
