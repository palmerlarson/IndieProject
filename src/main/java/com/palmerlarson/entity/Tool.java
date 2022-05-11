package com.palmerlarson.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type user
 *
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

    /**
     * Instantiates a new Tool.
     *
     * @param positive_asset the positive asset
     * @param negative_asset the negative asset
     * @param user_id        the user id
     */
    public Tool(int positive_asset, int negative_asset, User user_id) {
        this.positive_asset = positive_asset;
        this.negative_asset = negative_asset;
        this.user_id = user_id;
    }

    /**
     * Instantiates a new Tool.
     */
    public Tool() {

    }

    /**
     * Gets tool id.
     *
     * @return the tool id
     */
    public int getTool_id() {
        return tool_id;
    }

    /**
     * Sets tool id.
     *
     * @param tool_id the tool id
     */
    public void setTool_id(int tool_id) {
        this.tool_id = tool_id;
    }

    /**
     * Gets positive asset.
     *
     * @return the positive asset
     */
    public int getPositive_asset() {
        return positive_asset;
    }

    /**
     * Sets positive asset.
     *
     * @param positive_asset the positive asset
     */
    public void setPositive_asset(int positive_asset) {
        this.positive_asset = positive_asset;
    }

    /**
     * Gets negative asset.
     *
     * @return the negative asset
     */
    public int getNegative_asset() {
        return negative_asset;
    }

    /**
     * Sets negative asset.
     *
     * @param negative_asset the negative asset
     */
    public void setNegative_asset(int negative_asset) {
        this.negative_asset = negative_asset;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public User getUser_id() {
        return user_id;
    }

    /**
     * Sets user id.
     *
     * @param user_id the user id
     */
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