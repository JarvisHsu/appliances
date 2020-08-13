package cn.hellojarvis.entity;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : JarvisHsu
 * @create 2020/08/11 22:28
 */
public class RequestPage {
    private Integer orderId;
    private Integer goodsId;
    private Integer userId;
    private Integer addrId;
    private Double price;
    private String status;
    private Integer fixId;
    private Integer senderId;
    private String comment;
    private String requestDate;
    private String updateDate;
    //外键表 产品表，用户信息，用户地址
    private Goods goods = new Goods();
    private UserInfo client = new UserInfo();
    private UserAddress userAddress = new UserAddress();
    private UserInfo fixer = new UserInfo();
    private UserInfo sender = new UserInfo();

    @Override
    public String toString() {
        return "RequestPage{" +
                "orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", addrId=" + addrId +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", fixId=" + fixId +
                ", senderId=" + senderId +
                ", comment='" + comment + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", goods=" + goods +
                ", client=" + client +
                ", userAddress=" + userAddress +
                ", fixer=" + fixer +
                ", sender=" + sender +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
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

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public UserInfo getClient() {
        return client;
    }

    public void setClient(UserInfo client) {
        this.client = client;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public UserInfo getFixer() {
        return fixer;
    }

    public void setFixer(UserInfo fixer) {
        this.fixer = fixer;
    }

    public UserInfo getSender() {
        return sender;
    }

    public void setSender(UserInfo sender) {
        this.sender = sender;
    }
}
