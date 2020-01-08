package manual.dao.impl;

import com.xuetang9.commons.jdbc.DbHelper;
import manual.beans.Pokemon;
import manual.dao.IPDao;

import java.util.List;

/**
 * @author 郑文斌Mz
 * @version 1.0.0
 * @date 2019/12/2610:06
 * @copyright &copy; <a href="http://www.xuetang9.com">老九学堂</a> 版权所有
 * @address 成都市西部国际金融中心2栋2201老九学堂
 */
public class PDao implements IPDao {
    @Override
    public int pCreate(Pokemon pokemon) {
        String sql = "insert into pokemon(icon, name, name_en, name_jp, type, egg_group, ability, ability_hidden, hp, atk, def, spatk, spdef, spd) values" +
                " (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return DbHelper.getSession().executeUpdate(sql,pokemon.);
    }

    @Override
    public int pCount() {
        return 0;
    }

    @Override
    public int pDelete(Pokemon pokemon) {
        return 0;
    }

    @Override
    public int pUpdate(Pokemon pokemon) {
        return 0;
    }

    @Override
    public Pokemon pInfoForId(int id) {
        return null;
    }

    @Override
    public List<Pokemon> readPInfo(int start, int limit) {
        return null;
    }

    @Override
    public int findPCount() {
        return 0;
    }

    @Override
    public List<Pokemon> findPInfo(int start, int limit, String find) {
        return null;
    }
}
