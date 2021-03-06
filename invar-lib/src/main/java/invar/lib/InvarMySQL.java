/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib;

import java.util.*;

public final class InvarMySQL extends InvarSQL {

    public InvarMySQL(String tableName, List<String> writable, Map<String, String> fieldMap) {
        super(tableName, writable, fieldMap);
    }

    public final String jdbcDriver() {
        return "com.mysql.jdbc.Driver";
    }

    public StringBuilder buildInsert() {
        StringBuilder s = new StringBuilder(512);
        StringBuilder v = new StringBuilder(256);
        s.append("INSERT INTO ");
        s.append('`').append(tableName).append('`');
        s.append(' ').append('(');
        int len = super.writable.size();
        for (int i = 0; i < len; i++) {
            String field = super.writable.get(i);
            s.append('`').append(field).append('`');
            v.append('?');
            if (i < len - 1) {
                s.append(',');
                v.append(',');
            }
        }
        s.append(')');
        s.append(" VALUES ");
        s.append('(').append(v).append(')');
        return s;
    }

    public StringBuilder buildSelect(String where, int pageNumber, int pageSize, String... fields) {
        int offset = pageSize * (Math.max(0, pageNumber) - 1);
        StringBuilder s = buildSelect(where, -1, fields);
        s.append(" LIMIT ");
        s.append(Math.max(1, pageSize));
        if (offset >= 0) {
            s.append(" OFFSET ");
            s.append(Math.max(0, offset));
        }
        return s;
    }

    public StringBuilder buildSelect(String where, int limit, String... fields) {
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
            s.append('`').append(field).append('`');
            if (!name.equals(field)) {
                s.append("AS");
                s.append('`').append(name).append('`');
            }
            if (i < len - 1) {
                s.append(',');
            }
        }
        s.append(" FROM ");
        s.append('`').append(tableName).append('`');
        buildWhereClause(s, where);
        if (limit > 0) {
            s.append(" LIMIT ").append(limit);
        }
        return s;
    }

    public StringBuilder buildUpdate(String where, String... fields) {
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
        s.append('`').append(tableName).append('`');
        s.append(" SET ");
        int len = result.size();
        for (int i = 0; i < len; i++) {
            String field = result.get(i);
            s.append('`').append(field).append('`');
            s.append('=').append('?');
            if (i < len - 1) {
                s.append(',');
            }
        }
        buildWhereClause(s, where);
        return s;
    }

    private void buildWhereClause(StringBuilder s, String where) {
        if (where == null || where.length() <= 0) {
            return;
        }
        s.append(" WHERE ");
        s.append(where);
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
