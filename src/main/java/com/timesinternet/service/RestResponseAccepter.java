package com.timesinternet.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.timesinternet.exception.BadRequestException;

public class RestResponseAccepter extends DefaultResponseErrorHandler  {

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		if(response.getStatusCode()==HttpStatus.BAD_REQUEST){
			JSONObject json;
			try {
				json = new JSONObject(IOUtils.toString(response.getBody()));
				throw new BadRequestException(json.getString("message"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			super.handleError(response);
		}
	}

}
