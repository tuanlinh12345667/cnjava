package your_package;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/time")
public class FormatFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Khởi tạo filter
    }

    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String format = httpRequest.getParameter("format");

        if (format != null && !format.isEmpty()) {
            // Kiểm tra định dạng hợp lệ (ví dụ: không chứa ký tự đặc biệt nguy hiểm)
            // Đây là một ví dụ đơn giản, bạn có thể thêm logic phức tạp hơn
            if (format.matches("^[a-zA-Z0-9:/ -]+$")) {
                // Định dạng hợp lệ, cho phép request đi tiếp
                chain.doFilter(request, response);
            } else {
                // Định dạng không hợp lệ, chuyển hướng về trang form với thông báo lỗi
                httpRequest.setAttribute("errorMessage", "Định dạng thời gian không hợp lệ (chỉ chấp nhận chữ, số, ':', '/', '-', ' ').");
                httpRequest.getRequestDispatcher("/time.jsp").forward(request, response);
            }
        } else {
            // Không có định dạng, cho phép request đi tiếp (Servlet sẽ xử lý lỗi này)
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Hủy filter
    }
}