import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.db.MemberEntry;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleTest {

    @Test
    public void test_01_ToJSON() {
        String hint = "MemberEntry.Create().toStringJSON()";
        String json = MemberEntry.Create().toStringJSON().trim();
        log(hint, json);
        Assert.assertEquals(json, "{\"id\":0,\"createTime\":-1,\"updateTime\":-1}");
    }

    @Test
    public void test_02_ToXML() {
        String hint = "MemberEntry.Create().toStringJSON()";
        String json = MemberEntry.Create().toStringXML().trim();
        log(hint, json);
        //Assert.assertEquals(json, "{\"id\":0,\"createTime\":-1,\"updateTime\":-1}");
    }

    @Test
    public void test_11_SqlInsert() {
        String hint = "MemberEntry.SQL.buildInsert()";
        String sql = MemberEntry.SQL.getBuilder().buildInsert().toString();
        Assert.assertEquals(sql,
            "INSERT INTO `tbl_member` (`phone`,`nick_name`) VALUES (?,?)");
        log(hint, sql);
    }


    @Test
    public void test_12_SqlUpdate() {
        String hint = "MemberEntry.SQL.buildUpdate()";
        String where = "`id`=2";
        String sql;

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where).toString();
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "nickName").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "nickName", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "nick_name", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "updateTime", "nick_name").toString();
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "phone_", "abc").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "id").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "update_time").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "updateTime").toString();
        Assert.assertEquals("", sql);

        sql = MemberEntry.SQL.getBuilder().buildUpdate(where, "id", "update_time", "updateTime").toString();
        Assert.assertEquals("", sql);
    }


    @Test
    public void test_13_SqlSelect() {

        String hint = "MemberEntry.SQL.buildSelect()";
        String where = "`id`=?";
        StringBuilder sql;

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, 10);
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(null, 15);
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(null, 1, 20, "phone", "nick_name");
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, 100);
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, 100, "phone");
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, 3, 50, "nick_name", "id");
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, -1, "nick_name", "id_");
        log(hint, sql);

        sql = MemberEntry.SQL.getBuilder().buildSelect(where, 100, "id_");
        Assert.assertEquals("", sql.toString());
    }

    private void log(String hint, CharSequence text) {
        System.out.print("| ");
        System.out.print(hint);
        System.out.print(" *--> ");
        System.out.println(text);
    }

}