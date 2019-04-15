package com.apitest.model;


public class ItemBatch {
    /**
     * ID
     */
    private Integer batchId;

    /**
     * 批次
     */
    private String batch;

    private String itemCode;

    /**
     * 批次条码
     */
    private String itemBatchBarCode;

    /**
     * 批次创建日期
     */
    private String createTime;

    /**
     * 供应商
     */
    private String supplerCode;

    /**
     * 单据号
     */
    private String detailNo;

    /**
     * 原始单据号
     */
    private String preBillNo;

    /**
     * 货主id
     */
    private Integer itemMasterId;

    /**
     * 仓库编码
     */
    private String wareCode;

    /**
     * 生产日期
     */
    private String productTime;

    /**
     * 当前价格
     */
    private String price;

    /**
     * 获取ID
     *
     * @return batch_id - ID
     */
    public Integer getBatchId() {
        return batchId;
    }

    /**
     * 设置ID
     *
     * @param batchId ID
     */
    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    /**
     * 获取批次
     *
     * @return batch - 批次
     */
    public String getBatch() {
        return batch;
    }

    /**
     * 设置批次
     *
     * @param batch 批次
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return item_code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * 获取批次条码
     *
     * @return item_batch_bar_code - 批次条码
     */
    public String getItemBatchBarCode() {
        return itemBatchBarCode;
    }

    /**
     * 设置批次条码
     *
     * @param itemBatchBarCode 批次条码
     */
    public void setItemBatchBarCode(String itemBatchBarCode) {
        this.itemBatchBarCode = itemBatchBarCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    /**
     * 获取供应商
     *
     * @return suppler_code - 供应商
     */
    public String getSupplerCode() {
        return supplerCode;
    }

    /**
     * 设置供应商
     *
     * @param supplerCode 供应商
     */
    public void setSupplerCode(String supplerCode) {
        this.supplerCode = supplerCode;
    }

    public String getDetailNo() {
        return detailNo;
    }

    public void setDetailNo(String detailNo) {
        this.detailNo = detailNo;
    }

    /**
     * 获取原始单据号
     *
     * @return pre_bill_no - 原始单据号
     */
    public String getPreBillNo() {
        return preBillNo;
    }

    /**
     * 设置原始单据号
     *
     * @param preBillNo 原始单据号
     */
    public void setPreBillNo(String preBillNo) {
        this.preBillNo = preBillNo;
    }

    /**
     * 获取货主id
     *
     * @return item_master_id - 货主id
     */
    public Integer getItemMasterId() {
        return itemMasterId;
    }

    /**
     * 设置货主id
     *
     * @param itemMasterId 货主id
     */
    public void setItemMasterId(Integer itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    /**
     * 获取仓库编码
     *
     * @return ware_code - 仓库编码
     */
    public String getWareCode() {
        return wareCode;
    }

    /**
     * 设置仓库编码
     *
     * @param wareCode 仓库编码
     */
    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}