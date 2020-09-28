package beanComponents;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableDataStatefulBean implements Serializable {
    private List<TableData> results;

    public TableDataStatefulBean() {
        results = new LinkedList<>();
    }

    public void addData(TableData tableData) {
        results.add(tableData);
    }


    public List<TableData> getResults() {
        return results;
    }

    public void setResults(List<TableData> results) {
        this.results = results;
    }
}
