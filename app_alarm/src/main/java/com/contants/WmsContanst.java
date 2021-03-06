package com.contants;

/**
 * 常量定义参数
 */
public interface WmsContanst {

    /**
     * 主机IP
     */
    public static final String HOST = "http://140.143.58.93:8888/api";


    /**
     * 仓储库存物资清单盘点结果提交
     */
    public static final String VERIFY_STOCK = HOST + "/materialOut/checkIfMaterialSell";

    /**
     * 波特率
     */
    public static final int baud = 115200;

    /**
     * 串口号
     */
    public static final String TTYS1 = "/dev/ttyS4";

    /**
     * 过门程序串口号
     */
    public static final String TTYMXC2 = "/dev/ttymxc2";

}
