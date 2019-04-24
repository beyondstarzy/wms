package com.contants;

/**
 * 常量定义参数
 */
public interface WmsContanst {

    /**
     * 主机IP
     */
    public static final String HOST = "http://127.0.0.1";

    /**
     * 仓储库存物资清单
     */
    public static final String STORGE_MATERIALINFL = HOST + "/api/getMaa";

    /**
     * 仓储库存物资清单盘点结果提交
     */
    public static final String STORGE_MATERIALINFL_INVENTORY_SUBMIT = HOST + "/api/getMaa";

    /**
     * 销售库存物资清单
     */
    public static final String SALE_MATERIALINFL = HOST + "/api/getMaa";

    /**
     * 销售库存物资清单盘点结果提交
     */
    public static final String SALE_MATERIALINFL_INVENTORY_SUBMIT = HOST + "/api/getMaa";

    /**
     * 临期物资清单
     */
    public static final String OUTTIME_INVENTORY_SUBMIT = HOST + "/api/getMaa";

    /**
     * 波特率
     */
    public static final int baud = 115200;

    /**
     * 串口号
     */
    public static final String TTYS1 = "/dev/ttyS4";

}