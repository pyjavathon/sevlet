package hello.sevlet.basic.request;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestBodyStringServlet" , urlPatterns = "/request-string-servlet")
public class RequestBodyStringServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	InputStream inputStream = request.getInputStream();
	 	String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
	 	System.out.println("message = " + message);
	 	
	 	response.getWriter().write("ok");
	}
}
