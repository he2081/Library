package jp.co.lib.library;
import java.util.*;

public class Bookdb {
	
	private ArrayList<BookInfo> bookList = new ArrayList<BookInfo>(); //本リスト
	
	//本の登録
	public Bookdb() {
		// TODO 自動生成されたコンストラクター・スタブ
		bookList.add(new BookInfo(0, "seraku1", "seraku ichiro", "serakusha", 2022));
		bookList.add(new BookInfo(1, "seraku2", "seraku jiro", "serakusha", 2022));
		bookList.add(new BookInfo(2, "seraku3", "seraku saburo", "serakusha", 2022));
		bookList.add(new BookInfo(3, "seraku4", "seraku shiro", "serakusha", 2022));
		bookList.add(new BookInfo(4, "seraku5", "seraku goro", "serakusha", 2022));
		bookList.add(new BookInfo(5, "seraku6", "seraku rokuro", "serakusha", 2022));
	}
	
	//ISBNコードを貰う→本の情報を返すメソッド
	public BookInfo passBookInfo(int isbnCode) {
		for(int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getCode() == isbnCode) {
				return bookList.get(i);
			}
		}
		return null;
	}

	//本のリストを全て表示
	public void showLibrary() {
		System.out.println("Book List");
		System.out.println("-----------------------------------");
		
		for(int i = 0; i < bookList.size(); i++) {
			System.out.println("ISBNコード: " + bookList.get(i).getCode());
			System.out.println("題名: " + bookList.get(i).getName());
			System.out.println("作者: " + bookList.get(i).getAuthor());
			System.out.println("出版社: " + bookList.get(i).getPublisher());
			System.out.println("出版年: " + bookList.get(i).getYear());
			System.out.println("-----------------------------------");
		}
	}
	
	//ゲッター
	public ArrayList<BookInfo> getBookList() {
		return bookList;
	}
}