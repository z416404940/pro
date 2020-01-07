import com.majortom.dao.MovieGroupMapper;
import com.majortom.entity.*;
import com.majortom.service.UserService;
import com.majortom.utils.DBHelper;
import org.junit.Test;

import java.io.IOException;

public class MybatisTest {


    @Test
    public void test() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        ImagesMapper mapper = sqlSession.getMapper(ImagesMapper.class);
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        Videos videos = new Videos(null, 3L, "安妮霍尔", "伍迪艾伦的经典作");
//        System.out.println(mapper.add(videos));
//        System.out.println(mapper.deleteById(1L, Videos.class));

//        UserMapper mapper = DBHelper.getMapper(UserMapper.class);
////        System.out.println(mapper.queryFollowingByUserId(5));
//        System.out.println(mapper.queryFollowingMovieGroupInfoByUserId(5));

//        MovieGroupMapper mapper = DBHelper.getMapper(MovieGroupMapper.class);
//        System.out.println(mapper.queryFollowingByUserId(5));
//        System.out.println(mapper.queryFansLimitByMovieGroupId(2,0,1));
//        System.out.println(mapper.queryFansLimitByMovieGroupId(2,1,1));
//        UserService userService = new UserService();
//        User(userId=null, userName=null, gender=null, age=null, birthday=null, tel=14123423432, email=null, address=null, idNum=null, nickName=x, password=xx, privileges=null, menus=null, folders=null, pageElements=null)
//        User(userId=null, userName=null, gender=null, age=null, birthday=null, tel=15566666666, email=null, address=null, idNum=null, nickName=15566666666, password=3abf00fa61bfae2fff9133375e142416, privileges=null, menus=null, folders=null, pageElements=null)
//        User user = new User();
//        user.setNickName("x");
//        user.setTel("14123423432");
//        user.setPassword("xx");
//        System.out.println(user);
//        System.out.println(userService.add(user));


//        System.out.println("_werawe".substring(1));
        MovieGroupMapper movieGroupMapper = DBHelper.getMapper(MovieGroupMapper.class);
        System.out.println(movieGroupMapper.getById(1L,MovieGroup.class));
//        System.out.println(mapper.queryCommentByUserId(5));
// User s = new User(null, "郑文斌",
//                1,30L , new Date(19970805), "16345345345",
//                "16345345345.com" ,"陕西" ,"111111199708053334" ,"胖虎" ,"123");
//        System.out.println(mapper.add(s));
//        User ss = new User(null, "李文海",
//                1,26L , new Date(19901010), "13543342134",
//                "13543342134.com" ,"江西" ,"111111199708053334" ,"蚊子" ,"123");
//        System.out.println(mapper.add(ss));
//        User sss = new User(null, "易恩雨",
//                1,26L , new Date(1997,8,5), "12165346546",
//                "12165346546.com" ,"陕西" ,"111111199708053334" ,"老易" ,"123");
//        System.out.println(mapper.add(sss));

//        System.out.println(s.getUserId());
//        System.out.println(mapper.queryIdentificationByUserId(1));
//        Images images = new Images(null, 1L, 1, "xxxxsss");
//        System.out.println(mapper.update(images));
//        System.out.println(mapper.getById(1L,Images.class));
//        System.out.println(mapper.updateByColumn(1L,Images.class,"imgUrl","ww"));
//        System.out.println(mapper.get(images));
//        System.out.println(mapper.add(images));
//        System.out.println(images.getCIId());
//        System.out.println(mapper.delete(images));
//        System.out.println(mapper.insert(s));
//        System.out.println(mapper.delete(s));
//        System.out.println(mapper.deleteById(7L, User.class));
//        System.out.println(mapper.deleteById(2L,Images.class));
//        System.out.println(mapper.get(1L,Images.class));
    }
}
