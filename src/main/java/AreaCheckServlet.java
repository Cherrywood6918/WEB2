import beanComponents.TableData;
import beanComponents.TableDataStatefulBean;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("application/json");
        TableDataStatefulBean tableDataStatefulBean = (TableDataStatefulBean)session.getAttribute("tableDataBean");
        if (tableDataStatefulBean == null) {
            tableDataStatefulBean = new TableDataStatefulBean();
        }
        session.setAttribute("tableDataBean", tableDataStatefulBean);
            try {
                double x = Double.parseDouble(req.getParameter("coordinateX"));
                double y = Double.parseDouble(req.getParameter("coordinateY"));
                double r = Double.parseDouble(req.getParameter("radius"));
                boolean flag = Boolean.parseBoolean(req.getParameter("flag"));
                boolean valid = flag?(rIsValid(r)):(xIsValid(x) && yIsValid(y) && rIsValid(r));
                if (valid) {
                    TableData tableData = dataGeneration(x, y, r);
                    tableDataStatefulBean.addData(tableData);
                    try(PrintWriter printWriter = resp.getWriter()) {
                        printWriter.println(new Gson().toJson(tableData));
                    }
                } else resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
    }

    private boolean checkArea(double x, double y, double r) {
        boolean sector = (x * x + y * y <= r / 2 * (r / 2)) && y >= 0 && x <= 0;
        boolean rect = ((y >= -r) && (x >= -r) && x <=0 && y <= 0);
        boolean triangle = (x - r / 2 <= y) && x >= 0 && y <= 0;
        return rect || sector || triangle;
    }

    private TableData dataGeneration(double x, double y, double r) {
        boolean res = checkArea(x, y, r);
        Date date = new Date();
        return new TableData(x, y, r, date, res);
    }

    private boolean xIsValid(double x) {
        Double[] xLists = {-5d, -4d, -3d, -2d, -1d, 0d, 1d, 2d, 3.d};
        return Arrays.asList(xLists).contains(x);
    }

    private boolean yIsValid(double y) {
        return y <= 5 && y >= -3;
    }

    private boolean rIsValid(double r) {
        return r >= 2 && r <= 5;
    }
}
