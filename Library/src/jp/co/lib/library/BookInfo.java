package jp.co.lib.library;

public class BookInfo {
	//プロパティ
    private int isbnCode; //ISBN　13桁の数字
    private String name; //題名
    private String author; //作者
    private String publisher; //出版社
    private int year; //出版年
    private boolean status; //状態
    
    //コンストラクター
    public BookInfo(int isbnCode, String name, String author, String publisher, int year, boolean status) {
        this.isbnCode = isbnCode;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.status = status;
    }
    
    public BookInfo(int isbnCode, String name, String author, String publisher, int year) {
        this(isbnCode,name,author,publisher,year,true); //true(貸し出し可)
    }
    
    //セッター・ゲッター
    public int getCode() {
        return isbnCode;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public int getYear() {
        return year;
    }
    
    //戻り値が文字列として認識されるゲッター
    public String getStatusString() {
        if(status) {
            return "□ 貸出可";
        }else {
            return "■ 貸出中";
        }
    }
    
    //戻り値がbooleanとして認識されるゲッター
    public boolean getStatus() {
        return status;
    }
    
    //真偽値を反転させる
    public void setStatus(boolean status) {
        this.status = !status;
    }
}