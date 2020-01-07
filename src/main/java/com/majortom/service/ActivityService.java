package com.majortom.service;

import com.majortom.base.BaseServer;
import com.majortom.dao.ActivityMapper;
import com.majortom.dao.ImagesMapper;
import com.majortom.dao.VideosMapper;
import com.majortom.entity.Activity;
import com.majortom.entity.Images;
import com.majortom.entity.Videos;
import com.majortom.service.impl.IActivityService;
import com.majortom.utils.DBHelper;

import java.util.List;

public class ActivityService  extends BaseServer<Activity,ActivityMapper> implements IActivityService{
    private VideosMapper videosMapper = DBHelper.getMapper(VideosMapper.class);
    private ActivityMapper mapper = DBHelper.getMapper(ActivityMapper.class);
    private ImagesMapper imagesMapper = DBHelper.getMapper(ImagesMapper.class);

    @Override
    public int count() {
        return mapper.count(Activity.class);
    }

    @Override
    public List<Activity> queryPage(int start, int limit) {
        return mapper.getByLimit(Activity.class, start, limit);
    }

    @Override
    public List<Activity> queryByNameDim(String name) {
        return mapper.queryActivityBySearch(name);
    }

    @Override
    public String[] queryImagePath(List<Activity> activities) {
        if (activities== null) {return null;}
        String[] path = new String[activities.size()];
        for (int i = 0; i < activities.size(); i++) {
            long videosId = activities.get(i).getVId();
            Videos byId = videosMapper.getById(videosId, Videos.class);
            Images img = imagesMapper.getById(byId.getCIId(), Images.class);
            path[i] = img.getImgUrl();
        }
        return path;
    }

}
