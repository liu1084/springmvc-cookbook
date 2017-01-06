package com.jim.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * Created by jim on 2017/1/7.
 * This class is ...
 */
@Controller
@RequestMapping(value = "/page")
public class PageController extends BaseController {
	private static final int BUFFER_SIZE = 4096;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index() {
		return "save-page";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	@ResponseBody
	public String save() {
		ExecuteShellComand obj = new ExecuteShellComand();
		String domainName = "http://localhost:8080/webapp/";
		String command = "wget -m -k --page-requisites -H --tries=10 -b -o wget.log --continue --remote-encoding=utf-8 " + domainName;
		String output = obj.executeCommand(command);
		System.out.println(output);
		return "saved!";
	}

	@RequestMapping(value = "/saveHtml", method = RequestMethod.GET)
	public void getLogFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);
		String filePath = "http://localhost:8080/webapp/page/";
		File downloadFile = new File(new URL(filePath).getContent().toString());
		//FileInputStream inputStream = new FileInputStream(downloadFile);
		InputStream inputStream = new URL(filePath).openStream();
		// get output stream of the response
		OutputStream outStream = response.getOutputStream();
		String mimeType = context.getMimeType(filePath);
		try {
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			System.out.println("MIME type: " + mimeType);

			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);


			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}


		} catch (Exception e) {
			logger.debug("Request could not be completed at this moment. Please try again.");
			e.printStackTrace();
		} finally {
			inputStream.close();
			outStream.close();
		}

	}
}
