package jp.co.lib.library;

public class SystemLibrary {
	//本棚
	Bookdb library; 
	
	//コンストラクター
	public SystemLibrary() {	
		library = new Bookdb();
	}
	
	//登録
	public void create(int isbnCode, String name, String author, String publisher, int year) {
		this.library.getBookList().add(new BookInfo(isbnCode, name, author, publisher, year)); //リストに追加
	}

	//貸出状況を変更
	//更新
	public void changeStatus(BookInfo book) { 
		book.setStatus(book.getStatus());
	}
	
	//削除
	
	//削除
	public void deleteBook(BookInfo book) { 
		library.getBookList().remove(book);
	}

}