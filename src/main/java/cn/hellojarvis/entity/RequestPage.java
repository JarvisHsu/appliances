package cn.hellojarvis.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 22:28
 */
public class RequestPage {
    private Integer goodsId;
    private Integer userId;
    private Integer addrId;
    private Double price;
    private String status;
    private String requestDate;
    private String updateDate;

    @Override
    public String toString() {
        return "RequestPage{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", addrId=" + addrId +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                '}';
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
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

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
