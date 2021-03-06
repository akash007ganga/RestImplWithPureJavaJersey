package producer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/fertocentiservjson")
public class RestConsumerEndPointJSON {
	
	/**
	 * Convert fto C.
	 * browser url: http://localhost:8080/rest-producer-consumer-with-plain-java/rest/fertocentiservjson
	 * @return the response
	 * @throws JSONException the JSON exception
	 */
	@GET
	@Produces("application/json")
	public Response convertFtoC() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);
 
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
	}
 
	/**
	 * Convert fto cfrom input.
	 * browser url: http://localhost:8080/rest-producer-consumer-with-plain-java/rest/fertocentiservjson/40
	 * @param f the f
	 * @return the response
	 * @throws JSONException the JSON exception
	 */
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = (f - 32) * 5 / 9;
		jsonObject.put("F Value", f);
		jsonObject.put("C Value", celsius);
 
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
