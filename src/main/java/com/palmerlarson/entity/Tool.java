package com.palmerlarson.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type user
 * @author palmerlarson
 */
@Entity(name = "Tool")
@Table(name = "tool")
public class Tool {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int tool_id;

    @Column(name = "positive_asset")
    private int positive_asset;

    @Column(name = "negative_asset")
    private int negative_asset;

    @OneToOne()
    @JoinColumn(name="user_id", foreignKey=@ForeignKey(name="tool_user_fk"))
    @GeneratedValue(strategy = GenerationType.AUTO)
    private User user_id;

    public Tool(int positive_asset, int negative_asset, User user_id) {
        this.positive_asset = positive_asset;
        this.negative_asset = negative_asset;
        this.user_id = user_id;
    }

    public Tool() {

    }

    public int getTool_id() {
        return tool_id;
    }

    public void setTool_id(int tool_id) {
        this.tool_id = tool_id;
    }

    public int getPositive_asset() {
        return positive_asset;
    }

    public void setPositive_asset(int positive_asset) {
        this.positive_asset = positive_asset;
    }

    public int getNegative_asset() {
        return negative_asset;
    }

    public void setNegative_asset(int negative_asset) {
        this.negative_asset = negative_asset;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return getTool_id() == tool.getTool_id() && getPositive_asset() == tool.getPositive_asset() && getNegative_asset() == tool.getNegative_asset() && getUser_id().equals(tool.getUser_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTool_id(), getPositive_asset(), getNegative_asset(), getUser_id());
    }
}