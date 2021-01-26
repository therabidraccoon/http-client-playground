package it.trr.httppg.http;

import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public class HttpRequestFactory {

	public static HttpUriRequest getHttpRequest(String method, String url) {
		HttpUriRequest ret = null;
		switch (method) {
		case "PUT":
			String jsonEntry = "{\r\n" + 
					"    \"numdoc\": \"123TEST2\"\r\n" + 
					"}";
			StringEntity requestEntity = new StringEntity(jsonEntry, ContentType.APPLICATION_JSON);
			HttpPut httpPut = new HttpPut(url);
			httpPut.setEntity(requestEntity);
			ret = httpPut;
			break;
		case "GET":
			ret = new HttpGet(url);
			break;
		case "POST":
			ret = null;
		case "DELETE":
			ret = new HttpDelete(url);
			break;
		default:
			ret = null;
		}
		ret.setHeader("Accept", "application/json");
		ret.setHeader("Content-type", "application/json");
		return ret;
	}

}
