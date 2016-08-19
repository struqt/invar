import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.db.MemberEntry;

/**
 * Created by wangkang on 8/18/16
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleTest {

    @Test
    public void testSqlInsert() {
        String hint = "MemberEntry.SQL.buildInsert()";
        String sql = MemberEntry.SQL.buildInsert().toString();
        Assert.assertEquals(sql,
            "INSERT INTO `tbl_member` (`phone`,`nick_name`) VALUES (?,?)");
        log(hint, sql);
    }

    @Test
    public void testSqlSelect() {
        String hint = "MemberEntry.SQL.buildSelect()";
        String where = "`id`=1";
        String sql;

        sql = MemberEntry.SQL.buildSelect(where).toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildSelect(where, "phone").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildSelect(where, "nick_name", "id").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildSelect(where, "id_").toString();
        Assert.assertEquals("", sql);
    }

    @Test
    public void testSqlUpdate() {
        String hint = "MemberEntry.SQL.buildUpdate()";
        String where = "`id`=2";
        String sql;

        sql = MemberEntry.SQL.buildUpdate(where).toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildUpdate(where, "nickName").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildUpdate(where, "nickName", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildUpdate(where, "nick_name", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildUpdate(where, "updateTime", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.buildUpdate(where, "phone_", "abc").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.buildUpdate(where, "id").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.buildUpdate(where, "update_time").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.buildUpdate(where, "updateTime").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.buildUpdate(where, "id", "update_time", "updateTime").toString();
        Assert.assertEquals("", sql);
    }

    private void log(String hint, CharSequence text) {
        System.out.print("| ");
        System.out.print(hint);
        System.out.print(" *--> ");
        System.out.println(text);
    }

}