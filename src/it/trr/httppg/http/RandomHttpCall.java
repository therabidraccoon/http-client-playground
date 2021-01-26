package it.trr.httppg.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RandomHttpCall {

	public void makeHttpCall(String method) {
		System.out.println("Making HTTP call with "+method+" method");

		String baseUrl = "myurl";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		

		String url = baseUrl + "testivanm/doc/1";
		HttpUriRequest httpReq = HttpRequestFactory.getHttpRequest(method, url);

		ResponseHandler<String> responseHandler = new ElasticSearchResponseHandler();
		try {
			String httpResponse = httpclient.execute(httpReq, responseHandler);
			System.out.println("Response:" + httpResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class ElasticSearchResponseHandler implements ResponseHandler<String> {

	@Override
	public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		int status = response.getStatusLine().getStatusCode();
		if (status >= 200 && status < 300) {
			HttpEntity entity = response.getEntity();
			if (entity == null) {
				return "";
			} else {
				return EntityUtils.toString(entity);
			}
		} else {
			return "" + status;
		}
	}

}