package com.jim.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by jim on 2017/1/7.
 * This class is ...
 */
@Controller
@RequestMapping(value = "/page")
public class PageController extends BaseController {
	private static final int BUFFER_SIZE = 4096;
	private String fileName = String.valueOf(Calendar.getInstance().getTimeInMillis()) + ".html";

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index() {
		return "save-page";
	}

	@RequestMapping(value = "/saveHtml", method = RequestMethod.GET)
	public void save(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "u", required = false, defaultValue = "") String u) throws Exception {
		if (Objects.equals(u, "") || u.equals(null) || StringUtils.isEmpty(u) || u.equals("undefined")){
			throw new Exception("url is null");
		}
		ServletContext context = request.getServletContext();

		try {
			URL url = new URL(u);
			URLConnection urlConnection = url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String inputLine;

			File downloadFile = new File(fileName);

			if (!downloadFile.exists()){
				downloadFile.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(downloadFile.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while((inputLine = bufferedReader.readLine()) != null){
				bufferedWriter.write(inputLine);
			}

			FileInputStream inputStream = new FileInputStream(downloadFile);
			// get output stream of the response
			OutputStream outStream = response.getOutputStream();
			String mimeType = context.getMimeType(downloadFile.getAbsolutePath());


			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}

			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFile.getName());
			response.setHeader(headerKey, headerValue);
			response.setContentType("text/html;charset=UTF-8");


			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			bufferedReader.close();
			bufferedWriter.close();
			inputStream.close();
			outStream.close();
			fileWriter.close();


		} catch (Exception e) {
			logger.debug("Request could not be completed at this moment. Please try again.");
			e.printStackTrace();
		}

	}
}
