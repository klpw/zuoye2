

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String phoneNumber = req.getParameter("phoneNumber");
        String qqNumber = req.getParameter("qqNumber");
        String username = req.getParameter("username");
        String code = req.getParameter("code");
        String psw = req.getParameter("psw");
        String repsw = req.getParameter("repsw");

        if (phoneNumber.length() != 11) {
            System.out.println("ÊÖ»úºÅÂë´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (qqNumber.length() < 5 || qqNumber.length() > 11) {
            System.out.println("QQÕËºÅ´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (username.length() < 2 || username.length() > 20) {
            System.out.println("ÓÃ»§Ãû´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (code.length() != 6) {
            System.out.println("ÑéÖ¤Âë´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (psw.length() < 6 || psw.length() > 16) {
            System.out.println("ÃÜÂë´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (!psw.equals(repsw)) {
            System.out.println("È·ÈÏÃÜÂë´íÎó");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else {
            System.out.println("×¢²á³É¹¦");
            req.getRequestDispatcher("regist_success.html").forward(req,resp);
        }
    }
}
