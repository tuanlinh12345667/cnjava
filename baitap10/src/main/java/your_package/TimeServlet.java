package your_package;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String format = request.getParameter("format");
        if (format != null && !format.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                String currentTime = sdf.format(new Date());
                request.setAttribute("currentTime", currentTime);

                HttpSession session = request.getSession();
                String previousFormat = (String) session.getAttribute("previousFormat");
                if (previousFormat != null && !previousFormat.equals(format)) {
                    request.setAttribute("formatChanged", true);
                }
                session.setAttribute("previousFormat", format);

                request.getRequestDispatcher("/time.jsp").forward(request, response);
            } catch (IllegalArgumentException e) {
                request.setAttribute("errorMessage", "Định dạng thời gian không hợp lệ.");
                request.getRequestDispatcher("/time.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Vui lòng chọn định dạng thời gian.");
            request.getRequestDispatcher("/time.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng về trang form nếu người dùng truy cập trực tiếp
        request.getRequestDispatcher("/time.jsp").forward(request, response);
    }
}