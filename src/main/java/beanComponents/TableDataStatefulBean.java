package beanComponents;

import java.io.Serializable;
import java.util.*;


public class TableDataStatefulBean implements Serializable {
    private List<TableData> results;

    public TableDataStatefulBean() {
        results = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableDataStatefulBean that = (TableDataStatefulBean) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "TableDataStatefulBean{" +
                "results=" + results +
                '}';
    }
}
