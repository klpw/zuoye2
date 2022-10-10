

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
            System.out.println("�ֻ��������");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (qqNumber.length() < 5 || qqNumber.length() > 11) {
            System.out.println("QQ�˺Ŵ���");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (username.length() < 2 || username.length() > 20) {
            System.out.println("�û�������");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (code.length() != 6) {
            System.out.println("��֤�����");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (psw.length() < 6 || psw.length() > 16) {
            System.out.println("�������");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else if (!psw.equals(repsw)) {
            System.out.println("ȷ���������");
            req.getRequestDispatcher("regist_unsuccess.html").forward(req,resp);
        }
        else {
            System.out.println("ע��ɹ�");
            req.getRequestDispatcher("regist_success.html").forward(req,resp);
        }
    }
}
