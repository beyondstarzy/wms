package com.anji.contants;

/**
 * 常量定义参数
 */
public interface VehicleContanst {

    /**
     * 主机IP
     */
    String HOST = "http://visp.anji-logistics.com/api-b";

    /**
     * 车辆盘点结果提交
     */
    String VEHICLE_INVENTORY_ACCESSDATA = HOST + "/business/service/inventory/detail/receiveInventoryDetail";

    /**
     * 波特率
     */
    int baud = 115200;

    /**
     * 过门程序串口号
     */
    String TTYMXC2 = "/dev/ttymxc2";

    //public static final String TTYS1 = "/dev/ttyS4";

    /**
     * 接口调用身份凭证
     */
    String IDENGITY="uid=17&key=baca04516e91c31087e60ea9fc662000";

    /**
     * 用户身份号
     */
    String USER_ID="17";

}