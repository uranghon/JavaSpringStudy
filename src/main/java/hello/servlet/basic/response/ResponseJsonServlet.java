package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Content-Type: application/json
        response.setContentType("application/json");

        HelloData helloData = new HelloData();
        helloData.setUsername("fromis");
        helloData.setAge(20);

        //{"username":"kim","age":20}
        String result = objectMapper.writeValueAsString(helloData); // json 형식으로 만들어 주는거

        response.getOutputStream().print(result);

        // application/json 은 기본적으로 utf-8 을 쓰는게 규약되어있다. 저게 보인다? 하면 utf-8 인거다.
        // 근데 getWriter를 쓰게 되면 ContentType 상관없이 지가 내부적으로 charset을 추가해준다.
        // 근데 그게 utf-8이 아닐수도 있다. 그래서 만약에 getWriter 로 응답할 때 charset을 지정 안해주면
        // 지 멋대로 나갈 위험이 있기에 uft-8 지정을 같이 해주어야 한다.
        // getOutputStream 을 통해 내보낼 때는 charset 지정 안하고 application/json 만 해도 된다.
        // response.setCharacterEncoding("utf-8");
        // response.getWriter().write(result);
    }
}
