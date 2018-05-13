package yapp.devcamp.fallInIdol;


import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FaceApi
{
	// **********************************************
	// *** Update or verify the following values. ***
	// **********************************************

	// Replace the subscriptionKey string value with your valid subscription key.
	public static final String subscriptionKey = "ba251cc33ced4f429d84789daff6ee01";

	// Replace or verify the region.
	//
	// You must use the same region in your REST API call as you used to obtain your subscription keys.
	// For example, if you obtained your subscription keys from the westus region, replace
	// "westcentralus" in the URI below with "westus".
	//
	// NOTE: Free trial subscription keys are generated in the westcentralus region, so if you are using
	// a free trial subscription key, you should not need to change this region.
	public static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";


	public String[] genderDetected(String url)
	{
		HttpClient httpclient = new DefaultHttpClient();
		String[] gender = {};
		try
		{
			URIBuilder builder = new URIBuilder(uriBase);

			// Request parameters. All of them are optional.
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "false");
//			builder.setParameter("returnFaceAttributes", "age,gender,headPose,smile,facialHair,glasses,emotion,hair,makeup,occlusion,accessories,blur,exposure,noise");
			builder.setParameter("returnFaceAttributes", "gender");

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

			// Request body.
//			StringEntity reqEntity = new StringEntity("{\"url\":\" + http://file.instiz.net/data/cached_img/upload/2/8/4/284849bb83ef367f26117fce4a5965f5.jpg\"}");
			StringEntity reqEntity = new StringEntity("{\"url\":\"" + url + "\"}");
			
			request.setEntity(reqEntity);

			// Execute the REST API call and get the response entity.
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null)
			{
				// Format and display the JSON response.
//				System.out.println("\nREST Response:\n");

				String jsonString = EntityUtils.toString(entity).trim();
				if (jsonString.charAt(0) == '[') {
					JSONArray jsonArray = new JSONArray(jsonString);
					int array_cnt = jsonArray.length();
					gender = new String[array_cnt];
					
					for (int i = 0; i < array_cnt; i++) { //JSONArray 내 json 개수만큼 for문 동작
				        JSONObject jsonObject = jsonArray.getJSONObject(i); //i번째 Json데이터를 가져옴
				        JSONObject item = (JSONObject) jsonObject.get("faceAttributes");
				        gender[i] = item.getString("gender");  //descripton 값을 배열에 저장
//				        System.out.println("JSON Object"+ jsonObject + "");
//				        System.out.println("JsonParsing"+ gender[i]);
				 
				    }
					
//					System.out.println(jsonArray.toString(2));
				}
				else if (jsonString.charAt(0) == '{') {
					JSONObject jsonObject = new JSONObject(jsonString);
//					System.out.println(jsonObject.toString(2));
				} else {
//					System.out.println(jsonString);
				}
				
				return gender;
			}
		}
		catch (Exception e)
		{
			// Display error message.
			System.out.println(e.getMessage());
		}
		return null;
	}
}

