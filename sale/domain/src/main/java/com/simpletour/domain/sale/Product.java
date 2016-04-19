package com.simpletour.domain.sale;

import com.simpletour.commons.data.domain.BaseDomain;

import javax.persistence.*;
import java.util.List;


/**
 * Author:  wangLin
 * Mail  :  wl@simpletour.com
 * Date  :  2016/4/19.
 * Remark:  产品退改规则的实体类
 */
@Entity
@Table(name = "SALE_PRODUCT")
public class Product extends BaseDomain{

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * 业务系统产品id，不是该实体类的id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 销售协议
     */
    @ManyToOne
    @JoinColumn(name = "agreement_id")
    private Agreement agreement;

    /**
     * 产品退款细则
     */
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @OrderBy("timing asc")
    private List<ProductRefundRule> refundRules;

    /**
     * 退款规则文字说明
     */
    @Column
    private String refund;

    /**
     * 截止下单时间，精确到秒的字符串
     */
    @Column
    private String deadline;

    /**
     * 备注
     */
    @Column(columnDefinition = "text")
    private String remark;

    /**
     * 版本号（乐观锁）
     */
    @Version
    private Integer version;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    public String getRefund() {
        return refund;
    }

    public void setRefund(String refund) {
        this.refund = refund;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
