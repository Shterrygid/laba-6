import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TableServlet")
public class TableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получаем параметры из запроса
        String title = request.getParameter("title");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int cols = Integer.parseInt(request.getParameter("cols"));
        String bgColor = request.getParameter("color"));
    }

    // Устанавливаем тип контента для ответа
        response.setContentType("text/html");

    // Получаем объект PrintWriter для отправки ответа клиенту
    PrintWriter out = response.getWriter();

    // Генерируем HTML-страницу с таблицей
        out.println("<html>");
        out.println("<head><title>" + title + "</title></head>");
        out.println("<body bgcolor='" + bgColor + "'>");
        out.println("<h2>" + title + "</h2>");
        out.println("<table border='1'>");

    // Генерируем ячейки таблицы
        for (int i = 0; i < rows; i++) {
        out.println("<tr>");
        for (int j = 0; j < cols; j++) {
            out.println("<td>Row " + (i + 1) + ", Col " + (j + 1) + "</td>");
        }
        out.println("</tr>");
    }

        out.println("</table>");
        out.println("</body></html>");

    // Закрываем PrintWriter
        out.close();
}

