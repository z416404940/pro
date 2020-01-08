package manual.dao;

/**
 * @author 郑文斌Mz
 * @version 1.0.0
 * @date 2019/12/2610:01
 * @copyright &copy; <a href="http://www.xuetang9.com">老九学堂</a> 版权所有
 * @address 成都市西部国际金融中心2栋2201老九学堂
 */
public interface IPDao {
    int pCreate(Pokemon pokemon);
    int pCount();
    int pDelete(Pokemon pokemon);
    int pUpdate(Pokemon pokemon);
    Pokemon pInfoForId(int id);
    List<Pokemon> readPInfo(int start, int limit);
    int findPCount();
    List<Pokemon> findPInfo(int start,int limit,String find);
}
