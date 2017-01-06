package com.jim.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jim on 2017/1/7.
 * This class is ...
 */
public class ExecuteShellComand {
	public static void main(String[] args) {

		ExecuteShellComand obj = new ExecuteShellComand();

		String domainName = "http://localhost:8080/webapp/";
		String command = "wget -m -k --page-requisites -H --tries=10 -b -o wget.log --continue --remote-encoding=utf-8 " + domainName;

		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	protected String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
