package cn.hellojarvis.entity;

import java.io.Serializable;

/**
 * (Havegoods)实体类
 *
 * @author makejava
 * @since 2020-08-11 21:55:51
 */
public class Havegoods implements Serializable {
    private static final long serialVersionUID = -10267022972485363L;
    
    private Integer goodsId;
    
    private Integer userId;
    
    private String status;

    @Override
    public String toString() {
        return "Havegoods{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}