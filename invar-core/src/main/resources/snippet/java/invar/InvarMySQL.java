package invar;

import java.util.*;

public final class InvarMySQL extends InvarSQL {

    public InvarMySQL(String tableName, List<String> writable, Map<String, String> fieldMap) {
        super(tableName, writable, fieldMap);
    }

    public final StringBuilder buildInsert() {
        StringBuilder s = new StringBuilder(512);
        StringBuilder v = new StringBuilder(256);
        s.append("INSERT INTO ");
        s.append('`');
        s.append(tableName);
        s.append('`');
        s.append(' ');
        s.append('(');
        int len = super.writable.size();
        for (int i = 0; i < len; i++) {
            String field = super.writable.get(i);
            s.append('`');
            s.append(field);
            s.append('`');
            v.append('?');
            if (i < len - 1) {
                s.append(',');
                v.append(',');
            }
        }
        s.append(')');
        s.append(" VALUES ");
        s.append('(');
        s.append(v);
        s.append(')');
        return s;
    }

    public final StringBuilder buildSelect(String where, String... fields) {
        StringBuilder s = new StringBuilder(512);
        List<String> filtered = filterFields(fields);
        if (filtered == null || filtered.size() <= 0) {
            return s;
        }
        s.append("SELECT ");
        int len = filtered.size();
        for (int i = 0; i < len; i++) {
            String field = filtered.get(i);
            String name = fieldMap.get(field);
            s.append('`');
            s.append(field);
            s.append('`');
            if (!name.equals(field)) {
                s.append("AS");
                s.append('`');
                s.append(name);
                s.append('`');
            }
            if (i < len - 1) {
                s.append(',');
            }
        }
        s.append(" FROM ");
        s.append('`');
        s.append(tableName);
        s.append('`');
        s.append(" WHERE ");
        s.append(where);
        return s;
    }

    public final StringBuilder buildUpdate(String where, String... fields) {
        StringBuilder s = new StringBuilder(512);
        List<String> filtered = filterFields(fields);
        if (filtered.size() <= 0) {
            return s;
        }
        List<String> result = new ArrayList<String>(filtered.size());
        for (String field : filtered) {
            if (writable.contains(field)) {
                result.add(field);
            }
        }
        if (result.size() <= 0) {
            return s;
        }
        s.append("UPDATE ");
        s.append('`');
        s.append(tableName);
        s.append('`');
        s.append(" SET ");
        int len = result.size();
        for (int i = 0; i < len; i++) {
            String field = result.get(i);
            s.append('`');
            s.append(field);
            s.append('`');
            s.append('=');
            s.append('?');
            if (i < len - 1) {
                s.append(',');
            }
        }
        s.append(" WHERE ");
        s.append(where);
        return s;
    }

    private List<String> filterFields(String... fields) {
        Set<String> includes = new HashSet<String>(fields.length);
        Collections.addAll(includes, fields);
        List<String> filtered = new ArrayList<String>(fieldMap.size());
        for (Map.Entry<String, String> i : fieldMap.entrySet()) {
            final String k = i.getKey();
            final String v = i.getValue();
            if (includes.size() > 0 && !includes.contains(k) && !includes.contains(v)) {
                continue;
            }
            filtered.add(k);
        }
        return filtered;
    }

}
