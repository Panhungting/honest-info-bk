package jp.co.honest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.honest.domain.Bulletin;

@Mapper
public interface BulletinRepository {

    @Select("SELECT" 
        + " bulletin_id, category, title, content, publish_date, expiry, publish_flag, created_at "
        + " FROM bulletin" 
        + " WHERE publish_flag=1"
        + " ORDER BY created_at DESC")
    List<Bulletin> selectPubished();
}