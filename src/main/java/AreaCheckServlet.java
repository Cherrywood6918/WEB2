import beanComponents.TableData;
import beanComponents.TableDataStatefulBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class AreaCheckServlet extends HttpServlet {
    private TableDataStatefulBean tableDataStatefulBean = new TableDataStatefulBean();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("tableDataBean", tableDataStatefulBean);
            try {
                double x = Double.parseDouble(req.getParameter("coordinateX"));
                double y = Double.parseDouble(req.getParameter("coordinateY"));
                double r = Double.parseDouble(req.getParameter("radius"));
                String flag = req.getParameter("flag");
                if (validate(x, y, r, flag)) {
                    TableData tableData = dataGeneration(x, y, r);
                    tableDataStatefulBean.addData(tableData);
                    try(PrintWriter printWriter = resp.getWriter()) {
                        rowTableGeneration(printWriter,tableData);
                    }
                } else resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
    }

    private void rowTableGeneration(PrintWriter printWriter, TableData tableData) {

        printWriter.println("<tr>");
        printWriter.println("<td>" + tableData.getX() + "</td>");
        printWriter.println("<td>" + tableData.getY() + "</td>");
        printWriter.println("<td>" + tableData.getR() + "</td>");
        printWriter.println("<td>" + tableData.getDate() + "</td>");
        printWriter.println("<td>" + tableData.getTime() + "</td>");
        printWriter.println("<td>" + tableData.getRes() + "</td>");
        printWriter.println("</tr>");
    }

    private String checkArea(double x, double y, double r) {
        boolean sector = (x * x + y * y <= r / 2 * (r / 2)) && y >= 0 && x <= 0;
        boolean rect = ((y >= -r) && (x >= -r) && x <=0 && y <= 0);
        boolean triangle = (x - r / 2 <= y) && x >= 0 && y <= 0;
        if (rect || sector || triangle) return "True";
        else return "False";
    }

    private TableData dataGeneration(double x, double y, double r) {
        float start = System.currentTimeMillis();
        String res = checkArea(x, y, r);
        float elapsed = System.currentTimeMillis() - start;
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        String time = format.format(date);
        return new TableData(x, y, r, time, elapsed, res);
    }

    private boolean validate(double x, double y, double r, String flag) {
        Double[] xLists = {-5.0, -4.0, -3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0};
        if (flag.equals("button")) return Arrays.asList(xLists).contains(x) && y <= 5 && y >= -3 && r >= 2 && r <= 5;
        else if (flag.equals("canvas")) return r >= 2 && r <= 5;
        else return  false;
    }
}
