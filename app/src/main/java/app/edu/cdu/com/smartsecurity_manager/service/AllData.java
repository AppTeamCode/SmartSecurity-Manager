package app.edu.cdu.com.smartsecurity_manager.service;

/**
 * 项目名：  SmartSecurity-Manager
 * 包名：    app.edu.cdu.com.smartsecurity_manager.service
 * 文件名：  AllData
 * 创建者：  zhl
 * 创建时间： 2017/3/7 12:53
 * 描述：
 */


public class AllData {
    private char face;		//界面代号activity
    private char cmd;		//等待应答的命令
    private char type;		//等待应答的报文类型
    private char sort;		//等待应答的报文来源
    private int time;		//挂起任务时间
    private int id;	//等到应答的对方id

    private int ipaddr;	//登录IP地址，如果等于服务器ip，表示转发过来的。
    private String port;		//登录端口
    private int	deviceId;			//设备id，中转时用

    private int logintime;		//登录时间
    private char state;		//登录状态
    private int recvseq;		//最近收到设备报文序号
    private int recvtime;		//最近收到设备报文时间
    private int sendseq;		//最近发送设备报文序号
    private int sendtime;		//最近发送设备报文时间
    private int waitnum;		//等待重发报文数量
    private String[] sendpkt_node ;	//等带重发报文列表

    private char code;		//任务代码：1、下载文件；2、查询未读消息；
    private char file[];
    private int fileId;
    private char md5[] ;//下载文件的md5
    private int num;	//文件大小或者查询数据的代码字

    public char getFace() {
        return face;
    }

    public void setFace(char face) {
        this.face = face;
    }

    public char getCmd() {
        return cmd;
    }

    public void setCmd(char cmd) {
        this.cmd = cmd;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getSort() {
        return sort;
    }

    public void setSort(char sort) {
        this.sort = sort;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(int ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getLogintime() {
        return logintime;
    }

    public void setLogintime(int logintime) {
        this.logintime = logintime;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public int getRecvseq() {
        return recvseq;
    }

    public void setRecvseq(int recvseq) {
        this.recvseq = recvseq;
    }

    public int getRecvtime() {
        return recvtime;
    }

    public void setRecvtime(int recvtime) {
        this.recvtime = recvtime;
    }

    public int getSendseq() {
        return sendseq;
    }

    public void setSendseq(int sendseq) {
        this.sendseq = sendseq;
    }

    public int getSendtime() {
        return sendtime;
    }

    public void setSendtime(int sendtime) {
        this.sendtime = sendtime;
    }

    public int getWaitnum() {
        return waitnum;
    }

    public void setWaitnum(int waitnum) {
        this.waitnum = waitnum;
    }

    public String[] getSendpkt_node() {
        return sendpkt_node;
    }

    public void setSendpkt_node(String[] sendpkt_node) {
        this.sendpkt_node = sendpkt_node;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public char[] getFile() {
        return file;
    }

    public void setFile(char[] file) {
        this.file = file;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public char[] getMd5() {
        return md5;
    }

    public void setMd5(char[] md5) {
        this.md5 = md5;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

