package hello.sevlet.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.sevlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyJsonServlet" , urlPatterns = "/request-json-servlet")
public class RequestBodyJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream inputStream = request.getInputStream();
		
		String messagebody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		
		System.out.println("messagebody = " + messagebody);
		
		HelloData helloData = objectMapper.readValue(messagebody, HelloData.class);
		
		System.out.println("hello.username = " + helloData.getUsername());
		System.out.println("hello.age = " + helloData.getAge());
		
		response.getWriter().write("ok");

	}
	
}
