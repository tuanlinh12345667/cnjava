package your_package;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    private static int requestCount = 0;

    /**
     *
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // Không cần xử lý gì khi request bị hủy
    }

    /**
     *
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        requestCount++;
        System.out.println("Yêu cầu thứ: " + requestCount + " đã được xử lý.");
    }
}