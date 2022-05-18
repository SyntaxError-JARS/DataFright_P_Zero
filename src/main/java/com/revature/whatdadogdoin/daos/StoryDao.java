package com.revature.whatdadogdoin.daos;

import com.revature.whatdadogdoin.models.StoryModel;
import com.revature.whatdadogdoin.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoryDao extends StoryModel {


    public StoryDao(Integer postID, String houseHoldUsername, Integer likeCount, String content) {
        super(postID, houseHoldUsername, likeCount, content);
    }

    public StoryDao() {
        super();
    }

    public StoryModel createStoryPost(String username, String content){

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "insert into my_posts values (default, ?, 0, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, content);

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0){
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }


    public boolean delete(Integer id){
        Connection conn = ConnectionFactory.getInstance().getConnection();{
            String sql = "delete from my_posts where post_id = ?";

            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                int checkInsert = ps.executeUpdate();

                if (checkInsert == 0){
                    throw new RuntimeException();
                }

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


}
