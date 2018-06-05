package com.open_open.mylibrary.utils;

/**
 * 常量
 */
public class Constant {
    // request参数
    public static final int REQ_QR_CODE = 11002; // // 打开扫描界面请求码
    public static final int REQ_PERM_CAMERA = 11003; // 打开摄像头
    public static final int auto_focus = 0; // 打开摄像头
    public static final int decode = 1; // 打开摄像头
    public static final int decode_failed=2;
    public static final int decode_succeeded=3;
    public static final int encode_failed=4;
    public static final int encode_succeeded=5;
    public static final int launch_product_query=6;
    public static final int quit=7;
    public static final int restart_preview=8;
    public static final int return_scan_result=9;
    public static final int search_book_contents_failed=10;
    public static final int search_book_contents_succeeded=11;

    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";
}
