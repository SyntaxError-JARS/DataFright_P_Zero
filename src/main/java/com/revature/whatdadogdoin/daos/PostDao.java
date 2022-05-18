package com.revature.whatdadogdoin.daos;

import com.revature.whatdadogdoin.models.PostModel;
import com.revature.whatdadogdoin.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDao extends PostModel {

    public PostDao(Integer commentID, Integer postID, String houseHoldUsername, String comment) {
        super(commentID, postID, houseHoldUsername, comment);
    }

    public PostDao(){
        super();
    }

    public PostModel createCommentPost(Integer storyID, String username, String comment){
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "insert into comment_s values (default, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, storyID);
            ps.setString(2, username);
            ps.setString(3, comment);

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

}
